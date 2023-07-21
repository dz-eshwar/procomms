package com.rorapps.procomms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @JmsListener(destination = "emailQueue")
    public void sendEmail(String emailBody){
        System.out.println("Message Being received::"+emailBody+" :: at time "+ LocalDateTime.now());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("eshwar.chagapuram@outlook.com","sake.winz@gmail.com");
        message.setSubject("test mail");
        message.setText(emailBody);

        javaMailSender.send(message);
        System.out.println("mail sent tyo queue");
    }
}
