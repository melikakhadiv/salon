package com.example.webprofile.model.service;

import com.example.webprofile.model.entity.Storage;
import com.example.webprofile.model.service.impl.ServiceImpl;

import java.util.List;

public class StorageService implements ServiceImpl<Storage,Long> {
    private static StorageService service = new StorageService();

    public StorageService() {
    }

    public static StorageService getService() {
        return service;
    }

    @Override
    public Storage save(Storage storage) throws Exception {
        return null;
    }

    @Override
    public Storage edit(Storage storage) throws Exception {
        return null;
    }

    @Override
    public Storage remove(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Storage> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Storage> findAllPaging(int pageNumber, int pageSize) throws Exception {
        return null;
    }

    @Override
    public Storage findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Long getRecordCount() throws Exception {
        return null;
    }
}
