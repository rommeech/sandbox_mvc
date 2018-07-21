package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.dao.BotDao;
import org.rp.sandboxmvc.model.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BotService extends AbstractService {

    private final BotDao botDao;

    @Autowired
    public BotService(BotDao botDao) {
        this.botDao = botDao;
    }

    @Transactional
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

    @Transactional
    public List<Bot> getBots(SearchCriteria searchCriteria) {
        if (searchCriteria.getOrderBy() == null) {
            searchCriteria.setOrder("id", OrderDirection.ASC);
        }
        return botDao.search(searchCriteria);
    }

    @Transactional
    public Long countBots(SearchCriteria searchCriteria) {
        return botDao.count(searchCriteria);
    }


    @Transactional
    public Bot getByToken(String token) {
        return botDao.getByToken(token);
    }

    @Transactional
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

    public List<Bot> getAllBots() {
        return botDao.getAllBots();
    }
}
