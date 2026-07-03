package com.conectamesa.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_ngos")
public class Ngo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ngoName;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public Ngo() {
    }

    //GETTERS E SETTERS 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNgoName() { return ngoName; }
    public void setNgoName(String ngoName) { this.ngoName = ngoName; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}