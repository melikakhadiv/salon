package com.example.webprofile.controller.api;


import com.example.webprofile.controller.exception.NoContentException;
import com.example.webprofile.model.entity.Invoice;
import com.example.webprofile.model.service.InvoiceService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/invoice")
public class InvoiceApi {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Invoice invoice) {
        try {
            return Response.ok().entity(InvoiceService.getService().save(invoice)).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Invoice invoice) {
        try {
            return Response.ok().entity(InvoiceService.getService().edit(invoice)).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id) {
        try {
            return Response.ok().entity(InvoiceService.getService().remove(id)).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            System.out.println("OUTPUT : "+InvoiceService.getService().findAll());
            return Response.ok().entity(InvoiceService.getService().findAll()).build();
        }catch (NoContentException e){
            return Response.noContent().build();
        }
        catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}") .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") String id) {
        System.out.println("FindById");
        System.out.println(id);

        try {
            return Response.ok().entity(InvoiceService.getService().findById(Long.valueOf(id))).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }
}
