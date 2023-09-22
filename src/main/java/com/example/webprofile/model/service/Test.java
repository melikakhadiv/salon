package com.example.webprofile.model.service;

import com.example.webprofile.model.common.JPA;
import com.example.webprofile.model.entity.Group;
import com.example.webprofile.model.repository.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
//        System.out.println(GroupService.getService().save(Group.builder().title("Root1").build()));
//        System.out.println(GroupService.getService().save(Group.builder().title("Root2").build()));
//        System.out.println(GroupService.getService().save(Group.builder().title("Root3").build()));



        EntityManager entityManager = JPA.getJpa().getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = criteriaBuilder.createQuery(Group.class);
        Root<Group> root = criteriaQuery.from(Group.class);


        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(Group.class)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();

        System.out.println(count);

        criteriaQuery.select(root);


//        criteriaQuery.where(criteriaBuilder.gt(root.get("id"),2));

//        criteriaQuery.groupBy().having();
//        criteriaQuery.where(criteriaBuilder.lt(root.get("id"),140));
//        criteriaQuery.where(criteriaBuilder.like(root.get("title"),"%1%"));
//        criteriaQuery.where(criteriaBuilder.between(root.get("id"),2,3));
//        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),2));
//        predicate[1] = criteriaBuilder.in(root.get("id").in(1,3));


//        Predicate[] predicate = new Predicate[2];
//        predicate[0] = criteriaBuilder.like(root.get("title"),"%1%");
//        predicate[1] = criteriaBuilder.gt(root.get("id"),100);
//        criteriaQuery.where(criteriaBuilder.or(predicate));

//    criteriaQuery.p


        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("title")));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("title")));


        TypedQuery<Group> groupTypedQuery = entityManager.createQuery(criteriaQuery);

        groupTypedQuery.setFirstResult(3);
        groupTypedQuery.setMaxResults(2);

//        System.out.println(groupTypedQuery.ge);

        List<Group> groupList = groupTypedQuery.getResultList();

        System.out.println(groupList);
    }
}
