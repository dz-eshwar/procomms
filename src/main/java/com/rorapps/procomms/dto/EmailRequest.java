package com.rorapps.procomms.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class EmailRequest implements Serializable {

    private String userName;
    private String otp;
}
