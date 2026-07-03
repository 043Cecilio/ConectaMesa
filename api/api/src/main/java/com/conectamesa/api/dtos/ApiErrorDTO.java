package com.conectamesa.api.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record ApiErrorDTO(
        LocalDateTime timestamp,
        int status,
        String error,
        List<String> messages,
        String path
) {
}
