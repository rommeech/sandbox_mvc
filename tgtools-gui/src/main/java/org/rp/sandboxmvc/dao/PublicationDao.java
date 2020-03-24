package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Publication;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublicationDao extends AbstractDao<Publication, Long> {

    public List<Publication> getPublicationsByChannel(Channel channel) {
        return this.getEntityManager().createQuery("FROM Publication WHERE channel = :channel ORDER BY dateCreated DESC")
                .setParameter("channel", channel)
                .getResultList();
    }
}
