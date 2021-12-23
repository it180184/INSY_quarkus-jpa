package at.htl.api;

import at.htl.model.person.AddressDTO;
import at.htl.model.person.PersonDTO;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/address")
@Produces(MediaType.APPLICATION_JSON)
public class AddressResource {

    private final PersonService personService;

    public AddressResource(PersonService personService) {
        this.personService = personService;
    }
    @Transactional
    @POST
    @Path("{ssn}")
    public Response addAddress(AddressDTO newAddress, @PathParam("ssn") String ssn) {
        var result = personService.addAddress(newAddress, ssn);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("all/cities")
    public Response getCityNames() {
        var cities = personService.getAllCityNames();
        return Response.ok(cities).build();
    }
}