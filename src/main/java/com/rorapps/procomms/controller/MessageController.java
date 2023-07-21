package com.rorapps.procomms.controller;


import com.rorapps.procomms.dto.EmailRequest;
import com.rorapps.procomms.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mail")
public class MessageController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public Mono<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        // Delegate to the service to process the email
        return emailService.processEmail(emailRequest);
    }
}
