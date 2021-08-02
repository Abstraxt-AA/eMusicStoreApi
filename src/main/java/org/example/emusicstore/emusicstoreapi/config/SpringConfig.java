package org.example.emusicstore.emusicstoreapi.config;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * Configuration file meant to provide autowiring for the session bean to be used
 * in the DAO implementations (provided this way in order to support legacy code
 * written for the eMusicStore single-page project).
 */

/*
 * TODO: Change the implementation of the DAO classes to take advantage of new
 *  Spring Boot features
 */

@Configuration
public class SpringConfig {

    @Bean
    public Session session(@Autowired EntityManager entityManager) {
        return entityManager.unwrap(Session.class);
    }
}
