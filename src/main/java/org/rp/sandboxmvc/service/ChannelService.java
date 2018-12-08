package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.model.Channel;

import java.util.List;

public interface ChannelService {

    Channel getById(Long id);

    List<Channel> getChannels(SearchCriteria searchCriteria);

    Long countChannels(SearchCriteria searchCriteria);

    void update(Channel entity);

    void insert(Channel entity);

    void delete(Channel entity);

    List<Channel> getActiveChannels();

    void fixSearchCriteria(SearchCriteria searchCriteria);
}
