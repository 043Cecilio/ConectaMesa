package com.conectamesa.api.repositories;

import com.conectamesa.api.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}