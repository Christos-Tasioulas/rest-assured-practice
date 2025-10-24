// src/main/java/com/example/demo/util/MockMvcTestHelper.java
package com.example.demo.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jakarta.annotation.PostConstruct;

@Component
public class MockMvcTestHelper {

    private final WebApplicationContext context;
    @Getter
    private MockMvc mockMvc;

    @Autowired
    public MockMvcTestHelper(WebApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void init() {
        // Build MockMvc from the web context
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        // Optionally seed data here if needed for tests
    }

}
