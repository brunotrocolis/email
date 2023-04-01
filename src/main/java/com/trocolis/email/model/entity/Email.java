package com.trocolis.email.model.entity;

import com.trocolis.email.model.domai.SituacaoEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String usuario;
    private String remetente;
    private String destinatario;
    private String assunto;
    @Column(columnDefinition = "TEXT")
    private String testo;
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private SituacaoEmail situacao;

}
