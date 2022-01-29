package com.preach.kriegers.Contact;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class ContactConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(
//            ContactRepository repository) {
//        return args -> {
//            Contact tylor = new Contact(
//                    "Tylor",
//                    "tylorkrieger@gmail.com",
//                    "2003/JULY/7"
//            );
//
//            Contact jerry = new Contact(
//                    "Jerry",
//                    "tacoruler46@gmail.com",
//                    "2004/MAY/25"
//            );
//
//            repository.saveAll(
//                    List.of(tylor, jerry)
//            );
//        };
//    }
}
