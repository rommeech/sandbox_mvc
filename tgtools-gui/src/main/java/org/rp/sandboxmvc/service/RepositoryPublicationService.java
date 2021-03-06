package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.PublicationDao;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "publicationService")
public class RepositoryPublicationService implements PublicationService {

    @Autowired
    private final PublicationDao publicationDao;

    public RepositoryPublicationService(PublicationDao publicationDao) {
        this.publicationDao = publicationDao;
    }

    @Transactional
    public void insert(Publication model) {
        publicationDao.insert(model);
    }

    @Transactional
    public void delete(Publication model) {
        publicationDao.delete(model);
    }

    @Transactional(readOnly = true)
    public List<Publication> getPublicationsByChannel(Channel channel) {
        return publicationDao.getPublicationsByChannel(channel);
    }

}
