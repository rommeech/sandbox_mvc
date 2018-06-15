package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.AbstractModel;
import org.rp.sandboxmvc.model.feed.Post;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T extends AbstractModel<K>, K extends Serializable> {

    // We don't have getAll here cause it make no sense, it is dangerous for big tables,
    // and DAO classes can implement it itself.

    public abstract T getById(K id);

    public abstract void insert(T model);

    public abstract void update(T model);

    public abstract void delete (T model);
}
