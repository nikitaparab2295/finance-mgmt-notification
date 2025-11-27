package com.example.notification.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    void createNotification() throws Exception {
        String body = "{\"ownerId\":\"user1\",\"category\":\"Groceries\",\"level\":\"WARNING\",\"budgetAmount\":1000,\"expenseAmount\": 800,\"expenseDescription\":\"test\",\"totalSpent\":800,\"remaining\":200}";
        mvc.perform(post("/api/ notifications").contentType(MediaType.APPLICATION_JSON).content(body))
                        .andExpect(status().isCreated());
    }
}
