package com.rorapps.procomms.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessage implements Serializable {

    private String from;
    private String to;
    private String subject;
    private String body;
}
