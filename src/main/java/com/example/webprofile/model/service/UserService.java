package com.example.webprofile.model.service;

import com.example.webprofile.controller.exception.AccessDeniedException;
import com.example.webprofile.controller.exception.DuplicateDataException;
import com.example.webprofile.controller.exception.NoContentException;
import com.example.webprofile.model.entity.User;
import com.example.webprofile.model.repository.CrudRepository;
import com.example.webprofile.model.service.impl.ServiceImpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserService implements ServiceImpl<User, Long> {
    private static UserService service = new UserService();

    private UserService() {
    }

    public static UserService getService() {
        return service;
    }

    @Override
    public User save(User user) throws Exception {
        try (CrudRepository<User, Long> repository = new CrudRepository<>()) {
            if (findByUserName(user.getUserName()) == null) {
                repository.insert(user);
            } else {
                throw new DuplicateDataException("Username cant be duplicated !!!");
            }
            return user;
        }
    }

    @Override
    public User edit(User user) throws Exception {
        try (CrudRepository<User, Long> repository = new CrudRepository<>()) {
//            if (findByUserName(user.getUserName()) == null) {
                repository.update(user);
//            } else {
//                throw new DuplicateDataException("Username cant be duplicated !!!");
//            }
            return user;
        }
    }

    @Override
    public User remove(Long id) throws Exception {
        try (CrudRepository<User, Long> repository = new CrudRepository<>()) {
            User user = repository.selectById(User.class, id);

            if (user == null) {
                throw new NoContentException("No User Found");
            }
            user.setDeleted(true);
            repository.update(user);
            return user;
        }
    }

    @Override
    public List<User> findAll() throws Exception {
        try (CrudRepository<User, Long> repository = new CrudRepository<>()) {
            List<User> userList = repository.selectAll(User.class);

            if (userList.size() == 0) {
                throw new NoContentException("No User Found");
            }
            return userList;
        }
    }

    @Override
    public User findById(Long id) throws Exception {
        try (CrudRepository<User, Long> repository = new CrudRepository<>()) {
            User user = repository.selectById(User.class, id);

            if (user == null) {
                throw new NoContentException("No User Found");
            }
            return user;
        }
    }

    public User findByUserName(String userName) throws Exception {
        try (CrudRepository<User, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("userName", userName);

            User user = repository.getSingleResult("User.FindByUserName", params);

            if (user == null) {
                throw new NoContentException("No User Found");
            }
            return user;
        }
    }

    public User login(String userName, String password) throws Exception {
        try (CrudRepository<User, Long> repository = new CrudRepository<>()) {
            Map<String, Object> params = new HashMap<>();
            params.put("userName", userName);
            params.put("password", password);

            User user = repository.getSingleResult("User.FindByUserNameAndPassword", params);

            if (user == null) {
                throw new AccessDeniedException();
            }
            return user;
        }
    }


}
