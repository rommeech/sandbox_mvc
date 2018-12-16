package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Publication;

import java.util.List;

public interface PublicationService {

    void insert(Publication model);

    void delete(Publication model);

    List<Publication> getPublicationsByChannel(Channel channel);

}
