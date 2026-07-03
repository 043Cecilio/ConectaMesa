package com.conectamesa.api.repositories;

import com.conectamesa.api.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}