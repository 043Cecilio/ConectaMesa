package com.conectamesa.api.dtos;

import java.time.LocalDateTime;

public record DonationResponseDTO(
        Long id,
        String title,
        String description,
        Double quantity,
        String unit,
        String status,
        String imageUrl,
        LocalDateTime expirationDate,
        LocalDateTime createdAt
) {
}
