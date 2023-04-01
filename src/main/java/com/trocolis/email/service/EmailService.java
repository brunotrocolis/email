package com.trocolis.email.service;

import com.trocolis.email.model.domai.SituacaoEmail;
import com.trocolis.email.model.entity.Email;
import com.trocolis.email.model.repository.EmailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    public Email enviarEmail(Email email) {
        email.setDataHora(LocalDateTime.now());
        email.setSituacao(SituacaoEmail.NAO_ENVIADO);
        try {
            SimpleMailMessage mensagem = new SimpleMailMessage();
            mensagem.setFrom(email.getRemetente());
            mensagem.setTo(email.getDestinatario());
            mensagem.setSubject(email.getAssunto());
            mensagem.setText(email.getTexto());
            javaMailSender.send(mensagem);
            email.setSituacao(SituacaoEmail.ENVIADO);
        } catch (MailException e) {
            LOGGER.error("Problema ao tentar enviar e-mail:", e);
            email.setSituacao(SituacaoEmail.ERRO_ENVIO);
        } finally {
            return emailRepository.save(email);
        }
    }

}
