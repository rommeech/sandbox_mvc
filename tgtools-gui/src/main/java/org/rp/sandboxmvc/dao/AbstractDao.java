package org.rp.sandboxmvc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.model.AbstractModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T extends AbstractModel<K>, K extends Serializable> {

    // We don't have getAll here cause it make no sense, it is dangerous for big tables,
    // and DAO classes can implement it itself.

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    private final Class<T> persistenceClass;
    private static final Logger logger = LogManager.getLogger(AbstractDao.class);

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T getById(K id) {
        //EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        T model = entityManager.find(persistenceClass, id);
        //entityManager.close();
        return model;
    }

    public void insert(T model) {
        //EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.persist(model);
        //entityManager.close();
    }

    public void update(T model) {
        //EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.merge(model);
        //entityManager.close();
    }

    public void delete(T model) {
        //EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        entityManager.remove(entityManager.contains(model) ? model : entityManager.merge(model));
        //entityManager.close();
        //entityManager.remove(model);
    }


    // TODO: use metamodel here
    // https://www.ibm.com/developerworks/java/library/j-typesafejpa/#N102F2

    // TODO: add criteria, paginator, order objects
    public List<T> getByCriteria() {
        //EntityManager entityManager = DaoEntityManagerFactory.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(persistenceClass);
        Root<T> root = criteriaQuery.from(persistenceClass);
        criteriaQuery.select(root);

        /*
        if (criteria.isWhereNotEmpty()) {
            criteria.getWhere().forEach((k, v) ->
                criteriaQuery.where(criteriaBuilder.equal(root.get(k), v))
            );
        }

        if (criteria.getOrderBy() != null) {
            if (criteria.getOrderDir() == OrderDirection.DESC) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(criteria.getOrderBy())));
            }
            else {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(criteria.getOrderBy())));
            }
        }

        List<T> list = entityManager
                .createQuery(criteriaQuery)
                .setFirstResult(criteria.getPage() - 1)
                .setMaxResults(criteria.getSize())
                .getResultList();
        //entityManager.close();
                */

        // TODO: again - add criteria, paginator, order objects
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
        List<T> list = entityManager
                .createQuery(criteriaQuery)
                .setFirstResult(0)
                .setMaxResults(100)
                .getResultList();

        return list;
    }

    public Long countByCriteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> root = criteriaQuery.from(persistenceClass);
        criteriaQuery.select(criteriaBuilder.count(root));
        /*if (criteria.isWhereNotEmpty()) {
            criteria.getWhere().forEach((k, v) ->
                    criteriaQuery.where(criteriaBuilder.equal(root.get(k), v))
            );
        }*/
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
