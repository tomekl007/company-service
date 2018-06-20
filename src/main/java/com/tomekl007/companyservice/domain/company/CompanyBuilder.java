package com.tomekl007.companyservice.domain.company;

import java.util.List;
import java.util.Optional;

public class CompanyBuilder {
    private Integer companyId;
    private String name;
    private String address;
    private String city;
    private String country;
    private Optional<String> email;
    private Optional<String> phoneNumber;
    private List<BeneficialOwner> beneficialOwners;

    public CompanyBuilder setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public CompanyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public CompanyBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public CompanyBuilder setEmail(String email) {
        this.email = Optional.ofNullable(email);
        return this;
    }

    public CompanyBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Optional.ofNullable(phoneNumber);
        return this;
    }

    public CompanyBuilder setBeneficialOwners(List<BeneficialOwner> beneficialOwners) {
        this.beneficialOwners = beneficialOwners;
        return this;
    }

    public Company createCompany() {
        return new Company(companyId, name, address, city, country, email, phoneNumber, beneficialOwners);
    }
}