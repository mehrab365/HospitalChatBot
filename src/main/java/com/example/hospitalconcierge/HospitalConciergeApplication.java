package com.example.hospitalconcierge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class HospitalConciergeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalConciergeApplication.class, args);
        log.info("Hospital Concierge Application Started Successfully!");
    }

}
