package com.conectamesa.api.services;

import com.conectamesa.api.dtos.DonationDTO;
import com.conectamesa.api.dtos.DonationResponseDTO;
import com.conectamesa.api.models.Donation;
import com.conectamesa.api.repositories.DonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public List<DonationResponseDTO> getAllDonations() {
        return donationRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public DonationResponseDTO createDonation(DonationDTO dto) {
        Donation donation = new Donation();
        donation.setTitle(dto.title());
        donation.setDescription(dto.description());
        donation.setQuantity(dto.quantity());
        donation.setUnit(dto.unit());
        donation.setImageUrl(dto.imageUrl());
        donation.setExpirationDate(dto.expirationDate());

        Donation savedDonation = donationRepository.save(donation);
        return toResponseDto(savedDonation);
    }

    private DonationResponseDTO toResponseDto(Donation donation) {
        return new DonationResponseDTO(
                donation.getId(),
                donation.getTitle(),
                donation.getDescription(),
                donation.getQuantity(),
                donation.getUnit(),
                donation.getStatus(),
                donation.getImageUrl(),
                donation.getExpirationDate(),
                donation.getCreatedAt()
        );
    }
}
