package com.example.hospitalconcierge.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class HospitalDataService {

    @Value("classpath:hospital_data.json")
    private Resource hospitalDataResource;

    public String getHospitalDataAsText() {
        try {
            log.info("Loading hospital data from JSON...");
            String data = StreamUtils.copyToString(hospitalDataResource.getInputStream(), StandardCharsets.UTF_8);
            log.info("Hospital data loaded successfully. Size: {} chars", data.length());
            return data;
        } catch (IOException e) {
            log.error("Failed to load hospital data", e);
            throw new RuntimeException("Failed to load hospital data", e);
        }
    }
}
