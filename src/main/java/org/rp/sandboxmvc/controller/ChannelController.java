package org.rp.sandboxmvc.controller;

import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.model.Status;
import org.rp.sandboxmvc.model.tg.Channel;
import org.rp.sandboxmvc.service.feed.FeedService;
import org.rp.sandboxmvc.service.tg.BotService;
import org.rp.sandboxmvc.service.tg.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/channels/")
public class ChannelController {

    private final ChannelService channelService;
    private final BotService botService;
    private final FeedService feedService;

    @Autowired
    public ChannelController(ChannelService channelService, BotService botService, FeedService feedService) {
        this.channelService = channelService;
        this.botService = botService;
        this.feedService = feedService;
    }

    @RequestMapping(value = {"/", "/list/"}, method = RequestMethod.GET)
    public String channelList(Model model, SearchCriteria searchCriteria) {
        model.addAttribute("channels", channelService.getChannels(searchCriteria));
        model.addAttribute("total", channelService.countChannels(searchCriteria));
        return "tg/channel_list";
    }

    @RequestMapping(value = "/edit/{id}/", method = RequestMethod.GET)
    public String channelEdit(Model model, @PathVariable("id") Long id) {

        Channel channel = channelService.getById(id);
        if (channel == null) {
            throw new NotFoundException("Invalid URL, channel not found");
        }

        model.addAttribute("channel", channel);

        //TODO: code duplicate detected, try to do it using taglibs
        model.addAttribute("statuses", Status.values());

        //TODO: try to do it using taglib
        model.addAttribute("feeds", feedService.getAllFeeds());
        model.addAttribute("bots", botService.getAllBots());

        return "tg/channel_edit";
    }

    @RequestMapping(value = "/new/", method = RequestMethod.GET)
    public String channelNew(Model model) {

        model.addAttribute("channel", new Channel());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("feeds", feedService.getAllFeeds());
        model.addAttribute("bots", botService.getAllBots());

        return "tg/channel_edit";
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public String channelSave(Model model, @Valid @ModelAttribute("channel") Channel channel, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("statuses", Status.values());
            model.addAttribute("feeds", feedService.getAllFeeds());
            model.addAttribute("bots", botService.getAllBots());
            return "tg/channel_edit";
        }

        if (channel.getId() == null) {
            channelService.insert(channel);
        }
        else {
            channelService.update(channel);
        }

        //TODO: do something with this terrible GET parameter
        return "redirect:/channels/?success=true";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String channelDelete(Model model, @PathVariable("id") Long id) {

        Channel channel = channelService.getById(id);
        if (channel == null) {
            throw new NotFoundException("Invalid URL, channel not found");
        }

        channelService.delete(channel);

        return "redirect:/channels/?success=true";
    }

}
