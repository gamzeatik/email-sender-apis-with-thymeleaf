package com.example.email.service;

import com.example.email.model.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class EmailSenderServiceTest {
    @Autowired
    private EmailSenderService emailSenderService;

    @Test
    public void sendHtmlMessageTest() {
        Email email = new Email();
        email.setTo("gamze@gmail.com");
        email.setFrom("test@gmail.com");
        email.setSubject("Welcome Email");
        email.setTemplate("welcome-email.html");
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Gamze");
        properties.put("subscriptionDate", LocalDate.now().toString());
        properties.put("technologies", Arrays.asList("Express.js", "Java", "C#"));
        email.setProperties(properties);

        Assertions.assertDoesNotThrow(() -> emailSenderService.sendHtmlMessage(email));
    }
}
