package org.rp.sandboxmvc.dao;

import java.util.HashMap;
import java.util.Map;

public class SearchCriteria {

    private int page =  0;
    private int size = 50;
    private String orderBy;
    private OrderDirection orderDir;
    private Map<String, Object> where = new HashMap<>();

    public SearchCriteria() {
    }

    public SearchCriteria setLimit(int page, int size) {
        this.page = page;
        this.size = size;
        return this;
    }

    public SearchCriteria setLimit(int page) {
        this.size = page;
        return this;
    }

    public SearchCriteria setOrder(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public SearchCriteria setOrder(String orderBy, OrderDirection orderDir) {
        this.orderBy = orderBy;
        this.orderDir = orderDir;
        return this;
    }

    public SearchCriteria setWhere(String field, Object value) {
        this.where.put(field, value);
        return this;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public OrderDirection getOrderDir() {
        return orderDir;
    }

    public void setOrderDir(OrderDirection orderDir) {
        this.orderDir = orderDir;
    }

    public Map<String, Object> getWhere() {
        return where;
    }

    public void setWhere(Map<String, Object> where) {
        this.where = where;
    }

    public boolean isWhereNotEmpty() {
        return !where.isEmpty();
    }

    public void addWhere(String field, Object value) {
        where.put(field, value);
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "page=" + page +
                ", size=" + size +
                ", orderBy='" + orderBy + '\'' +
                ", orderDir=" + orderDir +
                ", where=" + where +
                '}';
    }


}
