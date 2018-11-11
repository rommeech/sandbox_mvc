package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Status;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDao extends AbstractDao<Channel, Long> {

    public List<Channel> getAllByStatus(Status status) {
        return this.getEntityManager()
                .createQuery("FROM Channel WHERE status = :status")
                .setParameter("status", status)
                .getResultList();
    }
}
