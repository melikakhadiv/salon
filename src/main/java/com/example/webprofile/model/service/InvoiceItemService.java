package com.example.webprofile.model.service;

import com.example.webprofile.model.entity.InvoiceItem;
import com.example.webprofile.model.service.impl.ServiceImpl;

import java.util.List;

public class InvoiceItemService implements ServiceImpl<InvoiceItem, Long> {
    private static InvoiceItemService service = new InvoiceItemService();

    public InvoiceItemService() {
    }

    public static InvoiceItemService getService() {
        return service;
    }

    @Override
    public InvoiceItem save(InvoiceItem invoiceItem) throws Exception {
        return null;
    }

    @Override
    public InvoiceItem edit(InvoiceItem invoiceItem) throws Exception {
        return null;
    }

    @Override
    public InvoiceItem remove(Long id) throws Exception {
        return null;
    }

    @Override
    public List<InvoiceItem> findAll() throws Exception {
        return null;
    }

    @Override
    public List<InvoiceItem> findAllPaging(int pageNumber, int pageSize) throws Exception {
        return null;
    }

    @Override
    public InvoiceItem findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Long getRecordCount() throws Exception {
        return null;
    }
}
