package com.asheef.portfolio.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asheef.portfolio.backend.dto.SendEmailDto;
import com.asheef.portfolio.backend.service.ContactService;
import com.asheef.portfolio.backend.utils.ResponseBody;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {
    
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<ResponseBody> sendEmail(@RequestBody @Valid SendEmailDto sendEmailDto) {
        return contactService.sendEmail(sendEmailDto);
    }

}
