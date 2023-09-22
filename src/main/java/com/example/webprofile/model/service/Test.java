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
//        GroupService.getService().remove(1);
        Group root1 = Group.builder().title("Root1").build();
        System.out.println(GroupService.getService().save(root1));

        Group root2 = Group.builder().title("Root2").build();
        System.out.println(GroupService.getService().save(root2));

        Group sub1_1 = Group.builder().title("Sub1-1").parent(root1).build();
        System.out.println(GroupService.getService().save(sub1_1));

        Group sub1_2 = Group.builder().title("Sub1-2").parent(root1).build();
        System.out.println(GroupService.getService().save(sub1_2));

        Group sub2 = Group.builder().title("Sub2").parent(root2).build();
        System.out.println(GroupService.getService().save(sub2));

        Group sub22 = Group.builder().title("Sub22").parent(sub2).build();
        System.out.println(GroupService.getService().save(sub22));
//
//        System.out.println(GroupService.getService().findByParentId(1));
//        System.out.println(GroupService.getService().findAllPaging(1,2));
//        System.out.println(GroupService.getService().findAllPaging(2,2));
//        System.out.println(GroupService.getService().findAllPaging(3,2));

//        EntityManager entityManager = JPA.getJpa().getEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Group> criteriaQuery = criteriaBuilder.createQuery(Group.class);
//        Root<Group> root = criteriaQuery.from(Group.class);
//
//        criteriaQuery.select(root);

//        criteriaQuery.where(criteriaBuilder.like(root.get("title"),"a%"));
//        criteriaQuery.groupBy().having();
//        criteriaQuery.where(criteriaBuilder.lt(root.get("id"),140));
//        criteriaQuery.where(criteriaBuilder.like(root.get("title"),"%1%"));
//        criteriaQuery.where(criteriaBuilder.between(root.get("id"),2,4));
//        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),2));
//        predicate[1] = criteriaBuilder.in(root.get("id").in(1,3));


//        Predicate[] predicate = new Predicate[2];
//        predicate[0] = criteriaBuilder.like(root.get("title"),"%1%");
//        predicate[1] = criteriaBuilder.gt(root.get("id"),100);
//        criteriaQuery.where(criteriaBuilder.or(predicate));
//
//
//        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("title")));
//        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("title")));
//
//
//        TypedQuery<Group> groupTypedQuery = entityManager.createQuery(criteriaQuery);
//
//        List<Group> groupList = groupTypedQuery.getResultList();
//        System.out.println(groupList);
    }
}
