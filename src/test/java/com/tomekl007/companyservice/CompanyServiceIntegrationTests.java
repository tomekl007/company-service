package com.tomekl007.companyservice;


import com.tomekl007.companyservice.api.BeneficialOwnerDto;
import com.tomekl007.companyservice.api.CompanyDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("integration")
public class CompanyServiceIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldAddNewCompany() {
        //given
        CompanyDto companyDto =
                new CompanyDto(1,
                        "A_company",
                        "street 34",
                        "krakow",
                        "Poland",
                        "email@gmail.com",
                        "516-025-234",
                        Arrays.asList(new BeneficialOwnerDto("owner"))
                );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        //when
        ResponseEntity<?> response = restTemplate
                .postForEntity("/company/",
                        companyDto,
                        Void.class,
                        headers
                );

        //then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }


    @Test
    public void shouldAddNewCompanyAndFetchItById() {
        //given
        CompanyDto companyDto =
                new CompanyDto(2,
                        "A_company",
                        "street 34",
                        "krakow",
                        "Poland",
                        "email@gmail.com",
                        "516-025-234",
                        Arrays.asList(new BeneficialOwnerDto("owner"))
                );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        //when
        restTemplate
                .postForEntity("/company/",
                        companyDto,
                        Void.class,
                        headers
                );

        ResponseEntity<CompanyDto> response = restTemplate.getForEntity("/company/2", CompanyDto.class);

        //then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody().getAddress()).isEqualTo("street 34");
        assertThat(response.getBody().getName()).isEqualTo("A_company");
        assertThat(response.getBody().getCity()).isEqualTo("krakow");
        assertThat(response.getBody().getEmail()).isEqualTo("email@gmail.com");
        assertThat(response.getBody().getPhoneNumber()).isEqualTo("516-025-234");
        assertThat(response.getBody().getBeneficialOwners()).isEqualTo(Arrays.asList(new BeneficialOwnerDto("owner")));
    }

    @Test
    public void shouldReturn404ForGetForNonExistingCompany() {
        //when
        ResponseEntity<CompanyDto> response = restTemplate.getForEntity("/company/100", CompanyDto.class);

        //then
        assertThat(response.getStatusCode().value()).isEqualTo(404);
    }

    @Test
    public void shouldAddTwoCompaniesAndReturnBothOfThem() {
        //given
        CompanyDto companyDto1 =
                new CompanyDto(200,
                        "A_company",
                        "street 34",
                        "krakow",
                        "Poland",
                        "email@gmail.com",
                        "516-025-234",
                        Arrays.asList(new BeneficialOwnerDto("owner"))
                );

        CompanyDto companyDto2 =
                new CompanyDto(201,
                        "A_company",
                        "street 34",
                        "krakow",
                        "Poland",
                        "email@gmail.com",
                        "516-025-234",
                        Arrays.asList(new BeneficialOwnerDto("owner"))
                );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        //when
        restTemplate
                .postForEntity("/company/",
                        companyDto1,
                        Void.class,
                        headers
                );

        restTemplate
                .postForEntity("/company/",
                        companyDto2,
                        Void.class,
                        headers
                );

        ResponseEntity<List<CompanyDto>> response = restTemplate.exchange("/companies", HttpMethod.GET, null, new ParameterizedTypeReference<List<CompanyDto>>() {
        });

        //then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody().size()).isEqualTo(2);

    }

    @Test
    public void shouldAddBeneficialOwnerForCompany() {
        //given
        CompanyDto companyDto =
                new CompanyDto(2000,
                        "A_company",
                        "street 34",
                        "krakow",
                        "Poland",
                        "email@gmail.com",
                        "516-025-234",
                        Arrays.asList(new BeneficialOwnerDto("owner"))
                );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        BeneficialOwnerDto beneficialOwnerDto = new BeneficialOwnerDto("owner2");

        //when
        restTemplate
                .postForEntity("/company/",
                        companyDto,
                        Void.class,
                        headers
                );

        restTemplate
                .postForEntity("/company/2000/beneficial-owner",
                        beneficialOwnerDto,
                        Void.class,
                        headers
                );

        ResponseEntity<CompanyDto> response = restTemplate.getForEntity("/company/2000", CompanyDto.class);

        //then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody().getAddress()).isEqualTo("street 34");
        assertThat(response.getBody().getName()).isEqualTo("A_company");
        assertThat(response.getBody().getCity()).isEqualTo("krakow");
        assertThat(response.getBody().getEmail()).isEqualTo("email@gmail.com");
        assertThat(response.getBody().getPhoneNumber()).isEqualTo("516-025-234");
        assertThat(response.getBody().getBeneficialOwners()).isEqualTo(
                Arrays.asList(
                        new BeneficialOwnerDto("owner"),
                        new BeneficialOwnerDto("owner2")
                )
        );
    }


}


