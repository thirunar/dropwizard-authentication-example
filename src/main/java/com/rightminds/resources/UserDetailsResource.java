package com.rightminds.resources;

import com.rightminds.model.UserDetails;
import com.rightminds.repository.UserDetailsRepository;
import com.rightminds.utils.ResponseFactory;
import io.dropwizard.auth.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/user-details")
@Produces(MediaType.APPLICATION_JSON)
public class UserDetailsResource {

	private UserDetailsRepository userDetailsRepository;

	public UserDetailsResource(UserDetailsRepository userDetailsRepository) {
		this.userDetailsRepository = userDetailsRepository;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response users(@Auth UserDetails userDetails, @QueryParam("name") String name) throws IOException {
		return ResponseFactory.ok(userDetailsRepository.findById(name));
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response users(@QueryParam("id") long id, @QueryParam("name") String name, @QueryParam("number") String number) {
		userDetailsRepository.add(id, name, number);
		return ResponseFactory.ok("Successfully added " + id);
	}
}