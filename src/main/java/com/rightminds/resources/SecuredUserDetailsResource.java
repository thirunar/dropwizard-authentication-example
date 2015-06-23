package com.rightminds.resources;


import com.rightminds.model.UserDetails;
import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/secured-user-details")
@Produces(MediaType.APPLICATION_JSON)

public class SecuredUserDetailsResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getGreeting(@Auth UserDetails user) {
		return "Authenticated";
	}
}