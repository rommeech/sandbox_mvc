package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.ChannelDao;
import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChannelRepositoryService implements ChannelService {

    @Autowired
    private final ChannelDao channelDao;

    public ChannelRepositoryService(ChannelDao channelDao) {
        this.channelDao = channelDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Channel getById(Long id) {
        return channelDao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Channel> getChannels(SearchCriteria searchCriteria) {
        return channelDao.search(searchCriteria);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countChannels(SearchCriteria searchCriteria) {
        return channelDao.count(searchCriteria);
    }

    @Override
    @Transactional
    public void update(Channel entity) {
        channelDao.update(entity);
    }

    @Override
    @Transactional
    public void insert(Channel entity) {
        channelDao.insert(entity);
    }

    @Override
    @Transactional
    public void delete(Channel entity) {
        channelDao.delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Channel> getActiveChannels() {
        return channelDao.getAllByStatus(Status.ACTIVE);
    }

    @Override
    public void fixSearchCriteria(SearchCriteria searchCriteria) {
        if (searchCriteria.getOrderBy() == null) {
            searchCriteria.setOrder("username", OrderDirection.ASC);
        }
    }

}
