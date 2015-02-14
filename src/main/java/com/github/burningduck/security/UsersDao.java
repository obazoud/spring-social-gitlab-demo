package com.github.burningduck.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Repository;

/**
 *
 * @author p.hoeffling
 */
@Repository
public class UsersDao {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UsersDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    public void createUser(String username) {
        jdbcTemplate.update("INSERT into users(username,password,enabled) values(?,?,true)", username, KeyGenerators.string().generateKey());
        jdbcTemplate.update("INSERT into authorities(username,authority) values(?,?)", username, "USER");
    }
}
