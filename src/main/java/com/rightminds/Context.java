package com.rightminds;


import com.rightminds.repository.UserDetailsRepository;
import org.skife.jdbi.v2.DBI;

public class Context {
    private static Context context;
    private UserDetailsRepository userDetailsRepository;
    private DBI dbInterface;

    public static Context getInstance() {
        if (context == null) {
            context = new Context();
        }
        return context;
    }
    
    public UserDetailsRepository userDetailsRepository() {
        if(userDetailsRepository == null) {
            userDetailsRepository = dbInterface.onDemand(UserDetailsRepository.class);
        }
        return userDetailsRepository;
    }

    public Context updateDBInterface(DBI dbInterface) {
        this.dbInterface = dbInterface;
        return this;
    }

}
