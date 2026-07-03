package com.conectamesa.api.dtos;

import jakarta.validation.constraints.*;

public record RegisterNgoDTO(
    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    String email,

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    String password,

    @NotBlank(message = "O nome da ONG é obrigatório.")
    String ngoName,

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter exatamente 14 dígitos numéricos.")
    String cnpj,

    @NotBlank(message = "O telefone é obrigatório.")
    String phone,

    @NotBlank(message = "O CEP é obrigatório.")
    String cep,
    @NotBlank(message = "A rua é obrigatória.")
    String street,
    @NotBlank(message = "O número é obrigatório.")
    String number,
    @NotBlank(message = "O bairro é obrigatório.")
    String neighborhood,
    @NotBlank(message = "A cidade é obrigatória.")
    String city,
    @NotBlank(message = "O estado (UF) é obrigatório.")
    String state
) {}