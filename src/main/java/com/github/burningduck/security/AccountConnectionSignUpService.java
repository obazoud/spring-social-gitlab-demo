package com.github.burningduck.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

/**
 *
 * @author p.hoeffling
 */
public class AccountConnectionSignUpService implements ConnectionSignUp {

    private final UsersDao usersDao;

    @Autowired
    public AccountConnectionSignUpService(UsersDao UsersDao) {
        this.usersDao = UsersDao;
    }

    @Override
    public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();
        usersDao.createUser(profile.getUsername());

        return profile.getUsername();
    }

}
