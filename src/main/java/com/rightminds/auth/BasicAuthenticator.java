package com.rightminds.auth;

import com.google.common.base.Optional;
import com.rightminds.model.UserDetails;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class BasicAuthenticator implements Authenticator<BasicCredentials, UserDetails> {

	private String login;
	/**
	 * User password.
	 */
	private String password;

	/**
	 * Constructor.
	 *
	 * @param login user-ID
	 * @param password password
	 */
	public BasicAuthenticator(String login, String password) {
		this.login = login;
		this.password = password;
	}

	/**
	 * The method authenticate users.
	 *
	 * @param credentials user credentials, in this case login and password.
	 * @return Optional containing User if present and empty if absent.
	 * @throws AuthenticationException
	 */
	@Override
	public Optional<UserDetails> authenticate(BasicCredentials credentials)
			throws AuthenticationException {
		if (password.equals(credentials.getPassword())
				&& login.equals(credentials.getUsername())) {
			return Optional.of(new UserDetails());
		} else {
			return Optional.absent();
		}
	}
}