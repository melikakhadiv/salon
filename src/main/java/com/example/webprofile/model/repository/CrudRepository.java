package com.example.webprofile.model.repository;

import com.example.webprofile.model.common.JPA;
import com.example.webprofile.model.entity.Base;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

public class CrudRepository<T extends Base, I> implements AutoCloseable {
    private EntityManager entityManager;

    public CrudRepository() {
        entityManager= JPA.getJpa().getEntityManager();
    }

    public T insert(T t) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(t);
        entityTransaction.commit();
        return t;
    }

    public T update(T t) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(t);
        entityTransaction.commit();
        return t;
    }

    public T delete(Class<T> tClass, I id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        T entity = entityManager.find(tClass, id);
        entityManager.remove(entity);
        entityTransaction.commit();
        return entity;
    }

    public T selectById(Class<T> tClass, I id) {
        T entity = entityManager.find(tClass, id);
        return entity;
    }

    public List<T> selectAll(Class<T> tClass) {
        String sql = "select entity from " + tClass.getAnnotation(Entity.class).name() + " entity ";
        Query query = entityManager.createQuery(sql);
        List<T> tList = query.getResultList();
        return tList;
    }

    public List<T> getResultList(String queryName, Map<String, Object> paramMap) {
        Query query = entityManager.createNamedQuery(queryName);
        if (paramMap != null) {
            for (String key : paramMap.keySet()) {
                query.setParameter(key, paramMap.get(key));
            }
        }
        List<T> tList = query.getResultList();
        return tList;
    }

    public T getSingleResult(String queryName, Map<String, Object> paramMap) {
        Query query = entityManager.createNamedQuery(queryName);
        if (paramMap != null) {
            for (String key : paramMap.keySet()) {
                query.setParameter(key, paramMap.get(key));
            }
        }
        List<T> tList = query.getResultList();
        return tList.get(0);
    }

//    public List<Group> test() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Group> cr = cb.createQuery(Group.class);
//        Root<Group> root = cr.from(Group.class);
//        cr.select(root);
//        cr.select(root).where(cb.gt(root.get("id"),1));
//        Query query = session.createQuery(cr);
//        List<Group> results = query.getResultList();
//        return results;
//    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
