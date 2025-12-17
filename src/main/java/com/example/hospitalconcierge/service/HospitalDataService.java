package com.example.hospitalconcierge.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class HospitalDataService {

    @Value("classpath:hospital_data.json")
    private Resource hospitalDataResource;

    public String getHospitalDataAsText() {
        try {
            return StreamUtils.copyToString(hospitalDataResource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load hospital data", e);
        }
    }
}
