package com.rorapps.procomms.service;


import com.rorapps.procomms.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EmailService {

    @Autowired
    private JmsTemplate jmsMessagingTemplate;

    public Mono<String> processEmail(EmailRequest emailRequest) {
        // Create email body using the entity instance
        String emailBody = createEmailBody(emailRequest);

        // Enqueue the email body to ActiveMQ
        jmsMessagingTemplate.convertAndSend("emailQueue", emailBody);

        // Return a Mono indicating the successful processing of the request
        return Mono.just("Email request processed successfully.");
    }

    private String createEmailBody(EmailRequest emailRequest) {
        String text = "Hello @user, Welcome to proconnex. Please use this otp to verify your account @otp.";
        text.replace("@user",emailRequest.getUserName()).replace("@otp",emailRequest.getOtp());
        return text;
        // Logic to create the email body using the provided entity
        // You can format the body using HTML, plain text, or any other format
        // Return the created email body as a String
    }
}
