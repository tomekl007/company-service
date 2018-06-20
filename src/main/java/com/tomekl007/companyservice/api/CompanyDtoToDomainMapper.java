package com.tomekl007.companyservice.api;

import com.tomekl007.companyservice.domain.company.BeneficialOwner;
import com.tomekl007.companyservice.domain.company.Company;
import com.tomekl007.companyservice.domain.company.CompanyBuilder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyDtoToDomainMapper {
    public static Company mapFromDto(CompanyDto companyDto) {
        return new CompanyBuilder()
                .setName(companyDto.getName())
                .setAddress(companyDto.getAddress())
                .setBeneficialOwners(mapFromDto(companyDto.getBeneficialOwners()))
                .setCity(companyDto.getCity())
                .setCompanyId(companyDto.getCompanyId())
                .setCountry(companyDto.getCountry())
                .setEmail(companyDto.getEmail())
                .setPhoneNumber(companyDto.getPhoneNumber())
                .createCompany();
    }

    private static List<BeneficialOwner> mapFromDto(List<BeneficialOwnerDto> beneficialOwners) {
        return beneficialOwners.stream().map(CompanyDtoToDomainMapper::mapBeneficialOwnerFromDto).collect(Collectors.toList());
    }

    public static BeneficialOwner mapBeneficialOwnerFromDto(BeneficialOwnerDto it) {
        return new BeneficialOwner(it.getName());
    }

    public static List<CompanyDto> mapToDto(Collection<Company> allCompanies) {
        return allCompanies.stream().map(CompanyDtoToDomainMapper::mapToDto).collect(Collectors.toList());
    }

    public static CompanyDto mapToDto(Company company) {
        return new CompanyDto(
                company.getCompanyId(),
                company.getName(),
                company.getAddress(),
                company.getCity(),
                company.getCountry(),
                company.getEmail(),
                company.getPhoneNumber(),
                map(company.getBeneficialOwners())

        );
    }

    private static List<BeneficialOwnerDto> map(List<BeneficialOwner> beneficialOwners) {
        return beneficialOwners.stream().map(CompanyDtoToDomainMapper::mapBeneficialOwnerToDto).collect(Collectors.toList());
    }

    public static BeneficialOwnerDto mapBeneficialOwnerToDto(BeneficialOwner beneficialOwner) {
        return new BeneficialOwnerDto(beneficialOwner.getName());
    }
}
