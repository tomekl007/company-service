package com.tomekl007.companyservice.api;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficialOwnerDto that = (BeneficialOwnerDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
