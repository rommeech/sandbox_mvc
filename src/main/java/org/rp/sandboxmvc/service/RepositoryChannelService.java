package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.ChannelDao;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.helper.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "channelService")
public class RepositoryChannelService implements ChannelService {

    @Autowired
    private final ChannelDao channelDao;

    public RepositoryChannelService(ChannelDao channelDao) {
        this.channelDao = channelDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Channel getById(Long id) {
        return channelDao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Channel> getChannels() {
        return channelDao.getByCriteria();
    }

    @Override
    @Transactional(readOnly = true)
    public Long countChannels() {
        return channelDao.countByCriteria();
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

}
