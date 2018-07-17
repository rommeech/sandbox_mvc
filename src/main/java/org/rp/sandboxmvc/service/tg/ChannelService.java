package org.rp.sandboxmvc.service.tg;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.dao.tg.ChannelDao;
import org.rp.sandboxmvc.model.tg.Channel;
import org.rp.sandboxmvc.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChannelService extends AbstractService {

    @Autowired
    private final ChannelDao channelDao;

    public ChannelService(ChannelDao channelDao) {
        this.channelDao = channelDao;
    }

    @Transactional
    public Channel getById(Long id) {
        return channelDao.getById(id);
    }

    @Transactional
    public List<Channel> getChannels(SearchCriteria searchCriteria) {
        if (searchCriteria.getOrderBy() == null) {
            searchCriteria.setOrder("id", OrderDirection.ASC);
        }
        return channelDao.search(searchCriteria);
    }

    @Transactional
    public Long countChannels(SearchCriteria searchCriteria) {
        return channelDao.count(searchCriteria);
    }

    @Transactional
    public void update(Channel entity) {
        channelDao.update(entity);
    }

    @Transactional
    public void insert(Channel entity) {
        channelDao.insert(entity);
    }

    @Transactional
    public void delete(Channel entity) {
        channelDao.delete(entity);
    }

}
