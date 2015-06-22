package com.rightminds;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.rightminds.resources.UserDetailsResource;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.migrations.MigrationsBundle;
import org.skife.jdbi.v2.DBI;

public class UserDetailsApplication extends Service<UserDetailsConfiguration> {
	private Context context;

	public static void main(String[] args) throws Exception {
		new UserDetailsApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<UserDetailsConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<UserDetailsConfiguration>() {
			@Override
			public DatabaseConfiguration getDatabaseConfiguration(UserDetailsConfiguration configuration) {
				return configuration.getDatabaseConfiguration();
			}
		});
	}

	@Override
	public void run(UserDetailsConfiguration configuration, Environment environment) throws Exception {
		DBIFactory factory = new DBIFactory();
		DBI dbInterface = factory.build(environment, configuration.getDatabaseConfiguration(), "Dropwizard");

		context = Context.getInstance()
				.updateDBInterface(dbInterface);
		final UserDetailsResource resource = new UserDetailsResource(context.userDetailsRepository());

		environment.addResource(resource);
	}
}
