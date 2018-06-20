package com.tomekl007.companyservice.api;

public class BeneficialOwnerDto {
    private String name;

    public BeneficialOwnerDto(String name) {
        this.name = name;
    }

    public BeneficialOwnerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
