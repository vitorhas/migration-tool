package com.vitorhas.migration;

import com.vitorhas.migration.services.InjectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"com.vitorhas.migration.controller", "com.vitorhas.migration"})
@EntityScan("com.vitorhas.migration.model")
@EnableJpaRepositories("com.vitorhas.migration.repository")
@EnableAsync
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private InjectionService injectionService;

    @Override
    public void run(String...args) throws Exception {
        logger.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.", Arrays.toString(args));
        if(args[0].equals("Injection")){
            injectionService.InjectionPass();
        }else if(args[0].equals("Process")){
           //Do something
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
