package com.example.email.service;

import com.example.email.model.Email;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/email/send/html")
    public void sendHtmlMessage(@RequestBody Email email) throws MessagingException {
        emailSenderService.sendHtmlMessage(email);
    }

    @PostMapping("/email/send")
    public void sendSimpleMessage(@RequestBody Email email) {
        emailSenderService.sendSimpleMessages(email);
    }
}
