package com.example.webprofile.controller.api;


import com.example.webprofile.controller.exception.NoContentException;
import com.example.webprofile.model.entity.Group;
import com.example.webprofile.model.service.GroupService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/group")
public class GroupApi {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Group group) {
        try {
            return Response.ok().entity(GroupService.getService().save(group)).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Group group) {
        try {
            return Response.ok().entity(GroupService.getService().edit(group)).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Integer id) {
        try {
            return Response.ok().entity(GroupService.getService().remove(id)).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            System.out.println("OUTPUT : "+GroupService.getService().findAll());
            return Response.ok().entity(GroupService.getService().findAll()).build();
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
            return Response.ok().entity(GroupService.getService().findById(Integer.valueOf(id))).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/parent")
    public Response findByParents() {
        try {
            return Response.ok().entity(GroupService.getService().findParents()).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/parent/{parentId}")
    public Response findByParentId(@PathParam("parentId") String parentId) {
        System.out.println("FindByParentId");
        System.out.println(parentId);
        try {
            return Response.ok().entity(GroupService.getService().findByParentId(Integer.valueOf(parentId))).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }
}
