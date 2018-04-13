
package com.tugba.berlinclock.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author tugba
 */


@SpringBootApplication(scanBasePackages = {"com.tugba.berlinclock.service",
    "com.tugba.berlinclock.controller",})
@EnableAutoConfiguration
public class MainClass {

    public static void main(String[] args) {

        SpringApplication.run(MainClass.class, args);
    }

}
