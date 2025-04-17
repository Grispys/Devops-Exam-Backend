/*
    Project: Creating a fully functional flight website that contains passenger, airport, city, and aircraft
             related information all in one database through the use of Spring Boot and JPA. Book, manage
             flights & search for anything/anyone you want! This project is a collaboration between multiple
             people, who have created a front-end and back-end to provide a very intuitive, friendly user
             experience.

    Names: Joshua Youden, Matthew Verge, Mohammad Hossain, Cameron Beanland

    Date: April 17th, 2025
 */
package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class RestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}

