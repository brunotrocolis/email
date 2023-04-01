package com.trocolis.email.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {

    @NotBlank
    private String usuario;

    @NotBlank
    @Email
    private String remetente;

    @NotBlank
    @Email
    private String destinatario;

    @NotBlank
    private String assunto;

    @NotBlank
    private String testo;
}
