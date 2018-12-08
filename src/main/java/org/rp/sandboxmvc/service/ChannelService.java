package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.dao.ChannelDao;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Status;
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

    @Transactional(readOnly = true)
    public Channel getById(Long id) {
        return channelDao.getById(id);
    }

    @Transactional(readOnly = true)
    public List<Channel> getChannels(SearchCriteria searchCriteria) {
        return channelDao.search(searchCriteria);
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public List<Channel> getActiveChannels() {
        return channelDao.getAllByStatus(Status.ACTIVE);
    }
}
