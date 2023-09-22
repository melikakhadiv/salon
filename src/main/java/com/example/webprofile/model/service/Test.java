package com.example.webprofile.model.service;

import com.example.webprofile.model.entity.Group;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(GroupService.getService().save(Group.builder().title("Root").build()));
    }
}
