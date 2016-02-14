# Dropwizard Authentication
This project illustrates how we can implement the authentication mechanism using Dropwizard and also tells about connecting Postgres data and creating few REST APIs for adding data to the database. In this example, person details is being added to database using REST API after the authentication.

##Steps
```
$ cd your_repo_root/repo_name
$ gradle clean build
$ gradle run
```

This starts the service in 8080 port. If you browse http://localhost:8080/user-details?name=thiru the browser requests for the username and password. The username and password is in the dropwizard.yml (ideally, the username and password has to be fetched from other source like database). 

##Overview of project structure
* UserDetailsApplication is the Dropwizard Application class
* dropwizard.yml is the configuration file
* UserDetailsConfiguration is the Dropwizard Configuration class
* auth folder has the BasicAuthenticator where the authentication logic resides
* model folder has the domain objects. In this example UserDetails object has the details about user
* repository has the classes which helps in interacting with the database
