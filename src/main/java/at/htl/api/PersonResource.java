package at.htl.api;

import at.htl.model.person.PersonDTO;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/person")
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPeople() {
        var people = personService.getAllPeople();
        return Response.ok(people).build();
    }
}