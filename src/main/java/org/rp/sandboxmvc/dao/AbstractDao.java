package org.rp.sandboxmvc.dao;

import org.rp.sandboxmvc.model.AbstractModel;
import org.rp.sandboxmvc.model.feed.Post;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T extends AbstractModel<K>, K extends Serializable> {

    // We don't have getAll here cause it make no sense, it is dangerous for big tables,
    // and DAO classes can implement it itself.

    private Class<T> persistenceClass;

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T getById(K id) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        T model = entityManager.find(persistenceClass, id);
        entityManager.close();
        return model;
    }

    public void insert(T model) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.persist(model);
        entityManager.close();
    }

    public void update(T model) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.merge(model);
        entityManager.close();
    }

    public void delete (T model) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.remove(model);
        entityManager.close();
    }

    // https://developer.jboss.org/wiki/GenericDataAccessObjects
    // https://stackoverflow.com/questions/3403909/get-generic-type-of-class-at-runtime
    // https://stackoverflow.com/questions/18707582/get-actual-type-of-generic-type-argument-on-abstract-superclass

    public List<T> search(SearchCriteria criteria) {
        EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(persistenceClass);
        Root<T> root = criteriaQuery.from(persistenceClass);
        criteriaQuery.select(root);
        List<T> list = entityManager
                .createQuery(criteriaQuery)
                .setFirstResult(criteria.getLimitOffset())
                .setMaxResults(criteria.getLimitCount())
                .getResultList();
        entityManager.close();
        return list;
    }
}
