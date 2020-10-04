package com.example.oyerickshawbackend;

import Repositories.RideRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = RideRepository.class)
public class OyerickshawbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OyerickshawbackendApplication.class, args);
    }

}
