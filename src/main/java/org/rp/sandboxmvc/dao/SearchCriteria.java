package org.rp.sandboxmvc.dao;

public class SearchCriteria {

    private int limitOffset =  0;
    private int limitCount  = 50;
    private String orderBy;
    private OrderDirection orderDir = OrderDirection.ASC;

    public SearchCriteria() {
    }

    public SearchCriteria setLimit(int offset, int count) {
        this.limitOffset = offset;
        this.limitCount = count;
        return this;
    }

    public SearchCriteria setLimit(int count) {
        this.limitCount = count;
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

    public int getLimitOffset() {
        return limitOffset;
    }

    public void setLimitOffset(int limitOffset) {
        this.limitOffset = limitOffset;
    }

    public int getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(int limitCount) {
        this.limitCount = limitCount;
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
}
