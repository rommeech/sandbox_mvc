package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.model.Channel;

import java.util.List;

public interface ChannelService {

    Channel getById(Long id);

    List<Channel> getChannels();

    Long countChannels();

    void update(Channel entity);

    void insert(Channel entity);

    void delete(Channel entity);

    List<Channel> getActiveChannels();
}
