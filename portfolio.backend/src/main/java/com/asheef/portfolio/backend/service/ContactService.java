package com.asheef.portfolio.backend.service;

import org.springframework.http.ResponseEntity;

import com.asheef.portfolio.backend.dto.SendEmailDto;
import com.asheef.portfolio.backend.utils.ResponseBody;

public interface ContactService {

    public ResponseEntity<ResponseBody> sendEmail(SendEmailDto sendEmailDto);
}
