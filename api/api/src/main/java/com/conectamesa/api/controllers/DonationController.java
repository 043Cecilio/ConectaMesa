package com.conectamesa.api.controllers;

import com.conectamesa.api.dtos.DonationDTO;
import com.conectamesa.api.dtos.DonationResponseDTO;
import com.conectamesa.api.services.DonationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping
    public List<DonationResponseDTO> getAllDonations() {
        return donationService.getAllDonations();
    }

    @PostMapping
    public ResponseEntity<DonationResponseDTO> createDonation(@Valid @RequestBody DonationDTO dto) {
        DonationResponseDTO savedDonation = donationService.createDonation(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDonation);
    }
}