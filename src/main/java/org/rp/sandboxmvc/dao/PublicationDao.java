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

    public List<Publication> getPublicationsByChannel(Channel channel) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.addWhere("channel", channel);
        searchCriteria.setOrder("id", OrderDirection.DESC);
        return this.search(searchCriteria);
    }
}
