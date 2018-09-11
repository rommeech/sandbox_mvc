package org.rp.sandboxmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.helper.BotEditor;
import org.rp.sandboxmvc.helper.FeedEditor;
import org.rp.sandboxmvc.model.Status;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.Bot;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/channels/")
public class ChannelController {

    private final ChannelService channelService;
    private final BotService botService;
    private final FeedService feedService;
    private static final Logger logger = LogManager.getLogger(ChannelController.class);

    @Autowired
    public ChannelController(ChannelService channelService, BotService botService, FeedService feedService) {
        this.channelService = channelService;
        this.botService = botService;
        this.feedService = feedService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Feed.class, new FeedEditor(feedService));
        binder.registerCustomEditor(Bot.class, new BotEditor(botService));
    }

    @RequestMapping(value = {"/", "/list/"}, method = RequestMethod.GET)
    public String channelList(Model model, SearchCriteria searchCriteria) {
        model.addAttribute("channels", channelService.getChannels(searchCriteria));
        model.addAttribute("total", channelService.countChannels(searchCriteria));
        return "channel_list";
    }

    @RequestMapping(value = "/edit/{id}/", method = RequestMethod.GET)
    public String channelEdit(Model model, @PathVariable("id") Long id) {

        Channel channel = channelService.getById(id);
        if (channel == null) {
            logger.error("Channel not found, invalid ID=" + id);
            throw new NotFoundException("Invalid URL, channel not found");
        }

        initEditModel(model);
        model.addAttribute("channel", channel);
        return "channel_edit";
    }

    private void initEditModel(Model model) {
        model.addAttribute("statuses", Status.values());
        model.addAttribute("feeds", feedService.getAllFeeds());
        model.addAttribute("bots", botService.getAllBots());
    }

    @RequestMapping(value = "/new/", method = RequestMethod.GET)
    public String channelNew(Model model) {

        initEditModel(model);
        model.addAttribute("channel", new Channel());

        return "channel_edit";
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public String channelSave(Model model, @Valid @ModelAttribute("channel") Channel channel, BindingResult result) {

        if (result.hasErrors()) {
            logger.error(result.getAllErrors());
            initEditModel(model);
            return "channel_edit";
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

    @RequestMapping(value = "/delete/{id}/", method = RequestMethod.GET)
    public String channelDelete(Model model, @PathVariable("id") Long id) {

        Channel channel = channelService.getById(id);
        if (channel == null) {
            throw new NotFoundException("Invalid URL, channel not found");
        }

        channelService.delete(channel);

        return "redirect:/channels/?success=true";
    }

    @RequestMapping(value = "/view/{id}/", method = RequestMethod.GET)
    public String channelView(Model model, @PathVariable("id") Long id, SearchCriteria searchCriteria) {

        Channel channel = channelService.getById(id);
        if (channel == null) {
            throw new NotFoundException("Invalid URL, channel not found");
        }

        // Channel (bot, feed)
        // Published posts
        // Not published posts
        // Paginator

        model.addAttribute("channel", channel);
        model.addAttribute("pubReports", channelService.getPublicationReports(channel, searchCriteria));

        return "channel_view";
    }

}
