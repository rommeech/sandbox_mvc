package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.Publication;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PublicationDao extends AbstractDao<Publication, Long> {

    public List<Publication> getAllByChannel(Channel channel) {

        /*CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Publication> criteriaQuery = criteriaBuilder.createQuery(Publication.class);
        Root<Publication> root = criteriaQuery.from(Publication.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("channel"), channel.getId()));

        return this.getEntityManager()
                .createQuery(criteriaQuery)
                .getResultList();
                */


        /*return this.getEntityManager()
                .createQuery("FROM Publication WHERE 'channel_id'=:channelId")
                .setParameter("channelId", channel.getId().toString())
                .getResultList();
                */

        return this.getEntityManager()
                .createQuery("FROM Publication WHERE channel = :channel")
                .setParameter("channel", channel)
                .setMaxResults(30)
                .getResultList();

    }

    public List<Publication> getPublicationsByChannel(Channel channel, SearchCriteria searchCriteria) {
        searchCriteria.addWhere("channel", channel);
        searchCriteria.setOrder("id", OrderDirection.DESC);
        return this.search(searchCriteria);
    }
}
