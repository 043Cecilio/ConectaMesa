package com.conectamesa.api.repositories;

import com.conectamesa.api.models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Long> {
}