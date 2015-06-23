package com.rightminds;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.DatabaseConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserDetailsConfiguration extends Configuration {

	@NotNull
	private String userName;

	@NotNull
	private String password;

	@JsonProperty
	public String getUserName() {
		return userName;
	}

	@JsonProperty
	public String getPassword() {
		return password;
	}

	@Valid
	@NotNull
	@JsonProperty
	private DataSourceFactory database = new DataSourceFactory();

	public DataSourceFactory getDataSourceFactory() {
		return database;
	}
}