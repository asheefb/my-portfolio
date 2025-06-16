package com.asheef.portfolio.backend.serviceimpl;

import com.asheef.portfolio.backend.dto.SendEmailDto;
import com.asheef.portfolio.backend.service.ContactService;
import com.asheef.portfolio.backend.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.reciever}")
    private String personalEmail;

    @Override
    public ResponseEntity<ResponseBody> sendEmail(SendEmailDto sendEmailDto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sendEmailDto.getEmail()); // User's email (used in the message, not for SMTP)
            message.setTo(personalEmail);             // Where you receive messages
            message.setSubject("Portfolio Contact: " + sendEmailDto.getSubject());
            message.setText("From: " + sendEmailDto.getName() + "\nEmail: " + sendEmailDto.getEmail() + "\n\n" + sendEmailDto.getMessage());

            mailSender.send(message);

            return ResponseEntity.ok(
                    ResponseBody.builder()
                            .message("Thank you for contacting me! I will get back to you soon.")
                            .data("Success")
                            .statusCode(200)
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(
                    ResponseBody.builder()
                            .message("Failed to send email: " + e.getMessage())
                            .data(null)
                            .statusCode(422)
                            .build()
            );
        }
    }
}
