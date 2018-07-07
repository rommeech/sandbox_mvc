package org.rp.sandboxmvc.service.tg;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.dao.tg.BotDao;
import org.rp.sandboxmvc.model.tg.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BotService {

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
    public void update(Bot bot) {
        botDao.update(bot);
    }

    @Transactional
    public void insert(Bot bot) {
        botDao.insert(bot);
    }

    @Transactional
    public void delete(Long id) {
        botDao.delete(this.getById(id));
    }

    @Transactional
    public List<Bot> list(Map<String, String> requestParams) {

        SearchCriteria searchCriteria = new SearchCriteria()
                .setWhere("feed", Long.valueOf(requestParams.get("bot")))
                .setLimit(0, 30)
                .setOrder("id", OrderDirection.ASC);

        return botDao.search(searchCriteria);
    }
}
