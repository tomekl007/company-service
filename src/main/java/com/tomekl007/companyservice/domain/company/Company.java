package com.tomekl007.companyservice.domain.company;

import java.util.List;
import java.util.Optional;

public class Company {
    private final Integer companyId;
    private final String name;
    private final String address;
    private final String city;
    private final String country;
    private final Optional<String> email;
    private final Optional<String> phoneNumber;
    private final List<BeneficialOwner> beneficialOwners;

    public Company(Integer companyId,
                   String name,
                   String address,
                   String city,
                   String country,
                   Optional<String> email,
                   Optional<String> phoneNumber,
                   List<BeneficialOwner> beneficialOwners) {
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.beneficialOwners = beneficialOwners;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    public List<BeneficialOwner> getBeneficialOwners() {
        return beneficialOwners;
    }

    public void addBeneficialOwner(BeneficialOwner beneficialOwner) {
        beneficialOwners.add(beneficialOwner);
    }
}
