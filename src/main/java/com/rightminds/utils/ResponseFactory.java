package com.rightminds.utils;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.*;

public class ResponseFactory {

	public static Response ok(String entity) {
		return Response
				.ok()
				.entity(entity)
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

	public static Response created(String entity) {
		return Response
				.status(CREATED)
				.entity(entity)
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

	public static Response internalServerError(String entity) {
		return Response
				.status(INTERNAL_SERVER_ERROR)
				.entity(entity)
				.build();
	}

	public static Response notFound(String entity) {
		return Response
				.status(NOT_FOUND)
				.entity(entity)
				.build();
	}

	public static Response badRequest(String entity) {
		return Response
				.status(BAD_REQUEST)
				.entity(entity)
				.build();
	}
}
