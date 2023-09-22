package com.example.webprofile.model.service;

import com.example.webprofile.model.entity.Invoice;
import com.example.webprofile.model.service.impl.ServiceImpl;

import java.util.List;

public class InvoiceService implements ServiceImpl<Invoice, Long> {
    private static InvoiceService service = new InvoiceService();

    public InvoiceService() {
    }

    public static InvoiceService getService() {
        return service;
    }

    @Override
    public Invoice save(Invoice invoice) throws Exception {
        return null;
    }

    @Override
    public Invoice edit(Invoice invoice) throws Exception {
        return null;
    }

    @Override
    public Invoice remove(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Invoice> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Invoice> findAllPaging(int pageNumber, int pageSize) throws Exception {
        return null;
    }

    @Override
    public Invoice findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Long getRecordCount() throws Exception {
        return null;
    }
}
