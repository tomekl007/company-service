package com.tomekl007.companyservice.api;

import java.util.List;

public class CompanyDto {
    private Integer companyId;
    private String name;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;
    private List<BeneficialOwnerDto> beneficialOwners;

    public CompanyDto(Integer companyId,
                      String name,
                      String address,
                      String city,
                      String country,
                      String email,
                      String phoneNumber,
                      List<BeneficialOwnerDto> beneficialOwners) {
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.beneficialOwners = beneficialOwners;
    }

    public CompanyDto() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BeneficialOwnerDto> getBeneficialOwners() {
        return beneficialOwners;
    }

    public void setBeneficialOwners(List<BeneficialOwnerDto> beneficialOwners) {
        this.beneficialOwners = beneficialOwners;
    }

}
