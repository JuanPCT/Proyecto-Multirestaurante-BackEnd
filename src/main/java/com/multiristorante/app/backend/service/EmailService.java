package com.multiristorante.app.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

@Service
@Transactional
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String email;
    public void sendListEmail(String emailTo){
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(email);
            helper.setTo(emailTo);
            helper.setSubject("Registro exitoso a multirestoranti");
            helper.setText("Gracias por registrarte");
            javaMailSender.send(message);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
