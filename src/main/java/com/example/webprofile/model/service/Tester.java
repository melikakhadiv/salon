package com.example.webprofile.model.service;

import com.example.webprofile.model.entity.Group;
import jakarta.inject.Inject;

public class Tester {
    public void save() throws Exception {
        System.out.println(GroupService.getService().save(Group.builder().title("Root").build()));
        System.out.println(GroupService.getService().save(Group.builder().title("Sub").build()));

    }
}
