package com.conectamesa.api.controllers;

import com.conectamesa.api.dtos.RegisterDonorDTO;
import com.conectamesa.api.dtos.RegisterNgoDTO;
import com.conectamesa.api.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register/donor")
    public ResponseEntity<String> registerDonor(@Valid @RequestBody RegisterDonorDTO dto) {
        authService.registerDonor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Doador cadastrado com sucesso!");
    }

    @PostMapping("/register/ngo")
    public ResponseEntity<String> registerNgo(@Valid @RequestBody RegisterNgoDTO dto) {
        authService.registerNgo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("ONG cadastrada com sucesso!");
    }
}