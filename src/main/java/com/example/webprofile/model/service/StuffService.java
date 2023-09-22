package com.example.webprofile.model.service;

import com.example.webprofile.model.entity.Stuff;
import com.example.webprofile.model.service.impl.ServiceImpl;

import java.util.List;

public class StuffService implements ServiceImpl<Stuff, Long> {
    private static StuffService service = new StuffService();

    public StuffService() {
    }

    public static StuffService getService() {
        return service;
    }


    @Override
    public Stuff save(Stuff stuff) throws Exception {
        return null;
    }

    @Override
    public Stuff edit(Stuff stuff) throws Exception {
        return null;
    }

    @Override
    public Stuff remove(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Stuff> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Stuff> findAllPaging(int pageNumber, int pageSize) throws Exception {
        return null;
    }

    @Override
    public Stuff findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Long getRecordCount() throws Exception {
        return null;
    }
}
