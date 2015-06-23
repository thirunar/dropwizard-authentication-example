# Dropwizard Authentication
This project illustrates how we can implement the authentication mechanism using Dropwizard and also tells about connecting Postgres data and creating few REST APIs for adding data to the database. In this example, I'm adding Person details (UserDetails) to the database.

##Steps
```
$ cd your_repo_root/repo_name
$ gradle clean build
$ gradle run
```

This starts the service in 8080 port. If you browse http://localhost:8080/user-details?name=thiru the browser requests for the username and password. In this example, I'm fetching the username and password from the dropwizard.yml but normally the username and password has to be fetched from database or LDAP server.

##Overview of project structure
* UserDetailsApplication is the Dropwizard Application class
* dropwizard.yml is the configuration file
* UserDetailsConfiguration is the Dropwizard Configuration class
* auth folder has the BasicAuthenticator where the authentication logic resides
* model folder has the domain objects. In this example UserDetails object has the details about user
* repository has the classes which helps in interacting with the database
