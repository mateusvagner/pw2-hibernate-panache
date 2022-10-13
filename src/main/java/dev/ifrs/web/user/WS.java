package dev.ifrs.web.user;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import dev.ifrs.interfaceadapters.user.controller.UserControllerInterface;
import dev.ifrs.model.User;

@Path("/user")
public class WS {

    @Inject
    UserControllerInterface userController;

    @POST
    @Path("/save/{name}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(@PathParam("name") String name) {
        try {
            return userController.save(name);
        } catch (Exception e) {
            throw new WebApplicationException(Status.FORBIDDEN);
        }

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<User> list() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return userController.listAll();
    }

}
