package com.tomekl007.companyservice.api;

public class CompanyValidator {
    static boolean companyIsValid(CompanyDto companyDto) {
        return companyDto.getAddress() != null &&
                companyDto.getCity() != null &&
                companyDto.getName() != null &&
                companyDto.getCompanyId() != null &&
                companyDto.getCountry() != null &&
                companyDto.getBeneficialOwners() != null &&
                companyDto.getBeneficialOwners().size() > 0;
    }
}
