package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.dao.BotDao;
import org.rp.sandboxmvc.model.Bot;
import org.rp.telegram.botapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class BotService extends AbstractService {

    @Autowired
    private BotDao botDao;

    @Autowired
    private TelegramApiService telegramApiService;

    public BotService() {
    }

    @Transactional(readOnly = true)
    public Bot getById(Long id) {
        return botDao.getById(id);
    }

    @Transactional
    public void update(Bot entity) {
        botDao.update(entity);
    }

    @Transactional
    public void insert(Bot entity) {
        botDao.insert(entity);
    }

    @Transactional
    public void delete(Bot entity) {
        botDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<Bot> getAllBots() {
        return botDao.getAllBots();
    }

    @Transactional(readOnly = true)
    public List<Bot> getBots(SearchCriteria searchCriteria) {
        if (searchCriteria.getOrderBy() == null) {
            searchCriteria.setOrder("id", OrderDirection.ASC);
        }
        return botDao.search(searchCriteria);
    }

    @Transactional(readOnly = true)
    public Long countBots(SearchCriteria searchCriteria) {
        return botDao.count(searchCriteria);
    }


    @Transactional(readOnly = true)
    public Bot getByToken(String token) {
        return botDao.getByToken(token);
    }

    @Transactional(readOnly = true)
    public Bot getByUsername(String username) {
        return botDao.getByUsername(username);
    }

    public boolean isTokenUnique(String token, Long id) {
        return isBotUnique(this.getByToken(token), id);
    }

    public boolean isUsernameUnique(String username, Long id) {
        return isBotUnique(this.getByUsername(username), id);
    }

    private boolean isBotUnique(Bot bot, Long id) {
        if (bot == null) {
            return true;
        }
        else if (id == null) {
            return false;
        }
        else {
            return id != bot.getId();
        }
    }

    @Transactional
    public void doGetMeRequest(Bot bot) throws ServiceException {
        User tgUser = telegramApiService.sendGetMeRequest(bot.getToken());
        updateBotFromTgUser(bot, tgUser);
    }

    private void updateBotFromTgUser(Bot bot, User tgUser) {
        bot.setUserId(tgUser.getId());
        bot.setUsername(tgUser.getUsername());
        bot.setFirstName(tgUser.getFirstName());
        bot.setLastName(tgUser.getLastName());
        botDao.update(bot);
    }
}
