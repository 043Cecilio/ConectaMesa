package com.conectamesa.api.config;

import com.conectamesa.api.models.*;
import com.conectamesa.api.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(
            UserRepository userRepo,
            AddressRepository addressRepo,
            DonorRepository donorRepo,
            DonationRepository donationRepo,
            org.springframework.security.crypto.password.PasswordEncoder passwordEncoder) {

        return args -> {
            if (userRepo.count() == 0) {
                System.out.println("🌱 Semeando dados de teste no banco...");

                User user = new User();
                user.setEmail("contato@supermercado.com");
                user.setPassword(passwordEncoder.encode("senha123"));
                user.setRole("DONOR");
                userRepo.save(user);

                Address address = new Address();
                address.setCep("01001-000");
                address.setStreet("Praça da Sé");
                address.setNumber("123");
                address.setNeighborhood("Centro");
                address.setCity("São Paulo");
                address.setState("SP");
                address.setLatitude(-23.55052);
                address.setLongitude(-46.633308);
                addressRepo.save(address);

                Donor donor = new Donor();
                donor.setCompanyName("Supermercado Preço Bom");
                donor.setCnpj("12345678000199");
                donor.setPhone("11999999999");
                donor.setUser(user);
                donor.setAddress(address);
                donorRepo.save(donor);

                Donation donation1 = new Donation();
                donation1.setTitle("Cesta de Tomates Orgânicos");
                donation1.setDescription("Aproximadamente 15kg de tomates maduros perfeitos para molho.");
                donation1.setQuantity(15.0);
                donation1.setUnit("KG");
                donation1.setExpirationDate(LocalDateTime.now().plusDays(2));
                donationRepo.save(donation1);

                Donation donation2 = new Donation();
                donation2.setTitle("Pães de Forma Integral");
                donation2.setDescription("20 pacotes de pão integral de marcas variadas retirados da prateleira.");
                donation2.setQuantity(20.0);
                donation2.setUnit("UNIDADES");
                donation2.setExpirationDate(LocalDateTime.now().plusDays(4));
                donationRepo.save(donation2);

                System.out.println("✅ Dados de teste inseridos com sucesso!");
            } else {
                System.out.println("O banco já possui dados. Pulando a semeadura.");
            }
        };
    }
}