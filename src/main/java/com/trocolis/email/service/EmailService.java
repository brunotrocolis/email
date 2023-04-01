package com.trocolis.email.service;

import com.trocolis.email.model.entity.Email;
import com.trocolis.email.model.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public void enviarEmail(Email email) {

    }

}
