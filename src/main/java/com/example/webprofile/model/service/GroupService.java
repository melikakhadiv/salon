package com.example.webprofile.model.service;

import com.example.webprofile.controller.exception.NoContentException;
import com.example.webprofile.model.entity.Group;
import com.example.webprofile.model.entity.Person;
import com.example.webprofile.model.repository.CrudRepository;
import com.example.webprofile.model.service.impl.ServiceImpl;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupService implements ServiceImpl<Group, Integer> {
    private static GroupService service = new GroupService();

    private GroupService() {
    }

    public static GroupService getService() {
        return service;
    }

    @Override
    public Group save(Group group) throws Exception {
        try (CrudRepository<Group, Integer> repository = new CrudRepository<Group, Integer>()) {
            return repository.insert(group);
        }
    }

    @Override
    public Group edit(Group group) throws Exception {
        try (CrudRepository<Group, Integer> repository = new CrudRepository<Group, Integer>()) {
            return repository.update(group);
        }
    }

    @Override
    public Group remove(Integer id) throws Exception {
        Group group = findById(id);
        group.setDeleted(true);
        try (CrudRepository<Group, Integer> repository = new CrudRepository<Group, Integer>()) {
            return repository.update(group);
        }
    }

    @Override
    public List<Group> findAll() throws Exception {
        try (CrudRepository<Group, Integer> repository = new CrudRepository<Group, Integer>()) {
            List<Group> groupList = repository.selectAll(Group.class);
            if (groupList.size() == 0) {
                throw new NoContentException("No Group Found");
            }
            return groupList;
        }
    }

//    @Override
//    public List<Group> findAllPaging(int pageNumber, int pageSize) throws Exception {
//        try (CrudRepository<Group, Long> repository = new CrudRepository<>()) {
//            List<Group> groupList = repository.selectAll(Group.class, pageNumber, pageSize);
//
//            if (groupList.size() == 0) {
//                throw new NoContentException("No Person Found");
//            }
//            return groupList;
//        }
//    }

    @Override
    public Group findById(Integer id) throws Exception {
        try (CrudRepository<Group, Integer> repository = new CrudRepository<Group, Integer>()) {
            Group group = repository.selectById(Group.class, id);
            if (group == null) {
                throw new NoContentException("No Group Found With Id " + id);
            }
            return group;
        }
    }

//    @Override
//    public Long getRecordCount() throws Exception {
//        try (CrudRepository<Group, Integer> repository = new CrudRepository<Group, Integer>()) {
//            return repository.getRecordCount(Group.class);
//        }
//    }

    public List<Group> findByParentId(Integer parentId) throws Exception {
        try (CrudRepository<Group, Integer> repository = new CrudRepository<Group, Integer>()) {

            Map<String, Object> params = new HashMap<>();
            params.put("parentId", parentId);

            List<Group> groupList = repository.getResultList("Group.FindByParentId", params);

            if (groupList.size() == 0) {
                throw new NoContentException("No Parent Group Found With Id " + parentId);
            }
            return groupList;
        }
    }

    public List<Group> findParents() throws Exception {
        try (CrudRepository<Group, Integer> repository = new CrudRepository<Group, Integer>()) {

            List<Group> groupList = repository.getResultList("Group.FindParents", null);

            if (groupList.size() == 0) {
                throw new NoContentException("No Parent Group Found");
            }
            return groupList;
        }
    }

//    todo : find deleted ????
}
