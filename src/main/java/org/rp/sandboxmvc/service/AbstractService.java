package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.OrderDirection;
import org.rp.sandboxmvc.dao.SearchCriteria;

// TODO: add abstract methods
public abstract class AbstractService {

    public void fixSearchCriteria(SearchCriteria searchCriteria) {
        if (searchCriteria.getOrderBy() == null) {
            searchCriteria.setOrder("id", OrderDirection.ASC);
        }
    }

}
