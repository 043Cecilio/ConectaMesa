package com.conectamesa.api.services;

import com.conectamesa.api.dtos.RegisterDonorDTO;
import com.conectamesa.api.dtos.RegisterNgoDTO;
import com.conectamesa.api.models.Address;
import com.conectamesa.api.models.Donor;
import com.conectamesa.api.models.Ngo;
import com.conectamesa.api.models.User;
import com.conectamesa.api.repositories.AddressRepository;
import com.conectamesa.api.repositories.DonorRepository;
import com.conectamesa.api.repositories.NgoRepository;
import com.conectamesa.api.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final DonorRepository donorRepository;
    private final NgoRepository ngoRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            AddressRepository addressRepository,
            DonorRepository donorRepository,
            NgoRepository ngoRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.donorRepository = donorRepository;
        this.ngoRepository = ngoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerDonor(RegisterDonorDTO dto) {
        User user = buildUser(dto.email(), dto.password(), "DONOR");
        userRepository.save(user);

        Address address = buildAddress(dto.cep(), dto.street(), dto.number(), dto.neighborhood(), dto.city(), dto.state());
        addressRepository.save(address);

        Donor donor = new Donor();
        donor.setCompanyName(dto.companyName());
        donor.setCnpj(dto.cnpj());
        donor.setPhone(dto.phone());
        donor.setUser(user);
        donor.setAddress(address);
        donorRepository.save(donor);
    }

    @Transactional
    public void registerNgo(RegisterNgoDTO dto) {
        User user = buildUser(dto.email(), dto.password(), "NGO");
        userRepository.save(user);

        Address address = buildAddress(dto.cep(), dto.street(), dto.number(), dto.neighborhood(), dto.city(), dto.state());
        addressRepository.save(address);

        Ngo ngo = new Ngo();
        ngo.setNgoName(dto.ngoName());
        ngo.setCnpj(dto.cnpj());
        ngo.setPhone(dto.phone());
        ngo.setUser(user);
        ngo.setAddress(address);
        ngoRepository.save(ngo);
    }

    private User buildUser(String email, String rawPassword, String role) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(role);
        return user;
    }

    private Address buildAddress(String cep, String street, String number, String neighborhood, String city, String state) {
        Address address = new Address();
        address.setCep(cep);
        address.setStreet(street);
        address.setNumber(number);
        address.setNeighborhood(neighborhood);
        address.setCity(city);
        address.setState(state);
        return address;
    }
}
