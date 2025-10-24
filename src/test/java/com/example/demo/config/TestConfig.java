package com.example.demo.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public TestDataInitializer testDataInitializer() {
        return new TestDataInitializer();
    }

    public static class TestDataInitializer {
        public void seed() {
            // seed data here
        }
    }
}


