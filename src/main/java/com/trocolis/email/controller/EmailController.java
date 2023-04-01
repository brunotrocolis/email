package com.trocolis.email.controller;

import com.trocolis.email.model.EmailDto;
import com.trocolis.email.model.entity.Email;
import com.trocolis.email.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("enviar")
    public ResponseEntity<Email> enviarEmail(@RequestBody @Valid EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        email = emailService.enviarEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
