package at.htl.api;

import at.htl.model.person.PersonDTO;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @Transactional
    @POST // not put because we will reject duplicates
    public Response addPerson(PersonDTO newPerson) {
        var result = personService.addPerson(newPerson);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("all")
    public Response getAllPeople() {
        var people = personService.getAllPeople();
        return Response.ok(people).build();
    }

    @GET
    @Path("all/awesome")
    public Response getAwesomePeopleCount() {
        var people = personService.getAwesomePeopleCount();
        return Response.ok(people).build();
    }
}