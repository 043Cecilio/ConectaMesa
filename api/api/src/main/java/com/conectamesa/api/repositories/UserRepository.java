package com.conectamesa.api.repositories;

import com.conectamesa.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}