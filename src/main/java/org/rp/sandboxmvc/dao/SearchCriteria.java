package org.rp.sandboxmvc.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SearchCriteria {

    private static final int DEFAULT_PAGE =  1;
    private static final int DEFAULT_SIZE = 50;

    private int page;
    private int size;
    private String orderBy;
    private OrderDirection orderDir;
    private Map<String, Object> where;

    public SearchCriteria() {
        this.where = new HashMap<>();
        this.page = DEFAULT_PAGE;
        this.size = DEFAULT_SIZE;
        this.orderDir = OrderDirection.ASC;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page >= 1) {
            this.page = page;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size >= 1) {
            this.size = size;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchCriteria)) return false;
        SearchCriteria that = (SearchCriteria) o;
        return page == that.page &&
                size == that.size &&
                Objects.equals(orderBy, that.orderBy) &&
                orderDir == that.orderDir &&
                Objects.equals(where, that.where);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size, orderBy, orderDir, where);
    }
}
