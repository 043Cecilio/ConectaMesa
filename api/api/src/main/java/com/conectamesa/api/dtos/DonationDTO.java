package com.conectamesa.api.dtos;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public record DonationDTO(
    @NotBlank(message = "O título da doação é obrigatório.")
    @Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres.")
    String title,

    @NotBlank(message = "A descrição é obrigatória.")
    String description,

    @NotNull(message = "A quantidade é obrigatória.")
    @Positive(message = "A quantidade deve ser um número maior que zero.")
    Double quantity,

    @NotBlank(message = "A unidade de medida (KG, LITROS, etc.) é obrigatória.")
    String unit,

    String imageUrl,

    @NotNull(message = "A data de validade é obrigatória.")
    @Future(message = "A data de validade deve ser uma data futura.")
    LocalDateTime expirationDate
) {}