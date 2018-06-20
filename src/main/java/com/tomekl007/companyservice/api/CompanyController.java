package com.tomekl007.companyservice.api;

import com.tomekl007.companyservice.domain.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @RequestMapping(value = "/company", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCompany(
            @RequestBody CompanyDto companyDto) {

        companyService.createCompany(CompanyDtoToDomainMapper.mapFromDto(companyDto));
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CompanyDto>> getCompanies() {

        List<CompanyDto> allCompanies = CompanyDtoToDomainMapper.mapToDto(companyService.getAllCompanies());
        return ResponseEntity.ok(allCompanies);
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCompanyDetails(@PathVariable("id") Integer id) {
        return companyService.getDetailsAboutCompanyById(id)
                .map(CompanyDtoToDomainMapper::mapToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @RequestMapping(value = "/company/{id}/beneficial-owner", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDto> getCompanies(
            @PathVariable("id") Integer id,
            @RequestBody BeneficialOwnerDto beneficialOwnerDto) {
        companyService.addBeneficialOwnerToCompany(id,
                CompanyDtoToDomainMapper.mapBeneficialOwnerFromDto(beneficialOwnerDto)
        );
        return ResponseEntity.ok().build();
    }
}
