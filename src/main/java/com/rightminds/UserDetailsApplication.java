package com.rightminds;

import com.rightminds.auth.BasicAuthenticator;
import com.rightminds.model.UserDetails;
import com.rightminds.resources.SecuredUserDetailsResource;
import com.rightminds.resources.UserDetailsResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.auth.Auth;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class UserDetailsApplication extends Application<UserDetailsConfiguration> {
	private Context context;

	public static void main(String[] args) throws Exception {
		new UserDetailsApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<UserDetailsConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<UserDetailsConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(UserDetailsConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
	}

	@Override
	public void run(UserDetailsConfiguration configuration, Environment environment) throws Exception {
		DBIFactory factory = new DBIFactory();
		DBI dbInterface = factory.build(environment, configuration.getDataSourceFactory(), "Dropwizard");

		context = Context.getInstance()
				.updateDBInterface(dbInterface);
		final UserDetailsResource resource = new UserDetailsResource(context.userDetailsRepository());
		final SecuredUserDetailsResource securedResource = new SecuredUserDetailsResource();

		environment.jersey().register(AuthFactory.binder(
				new BasicAuthFactory<UserDetails>(
						new BasicAuthenticator(configuration.getUserName(),
								configuration.getPassword()),
						"SECURITY REALM",
						UserDetails.class)));
		environment.jersey().register(resource);
		environment.jersey().register(securedResource);

	}
}
