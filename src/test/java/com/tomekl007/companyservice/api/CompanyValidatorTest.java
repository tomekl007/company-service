package com.tomekl007.companyservice.api;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CompanyValidatorTest {

    @Test
    public void shouldReturnThatCompanyIsValidIfHasAllNecessaryFieldsPresent() {
        //given
        CompanyDto companyDto =
                new CompanyDto(1,
                        "A_company",
                        "street 34",
                        "krakow",
                        "Poland",
                        null,
                        null,
                        Arrays.asList(new BeneficialOwnerDto("owner"))
                );

        //then
        assertThat(CompanyValidator.companyIsValid(companyDto)).isTrue();
    }

    @Test
    public void shouldReturnThatCompanyIsInvalid() {
        //given
        CompanyDto companyDto =
                new CompanyDto(1,
                        null,
                        "street 34",
                        "krakow",
                        "Poland",
                        null,
                        null,
                        Arrays.asList(new BeneficialOwnerDto("owner"))
                );

        //then
        assertThat(CompanyValidator.companyIsValid(companyDto)).isFalse();
    }

}