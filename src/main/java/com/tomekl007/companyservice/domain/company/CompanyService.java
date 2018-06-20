package com.tomekl007.companyservice.domain.company;

import com.tomekl007.companyservice.persistance.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    public Collection<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    public Optional<Company> getDetailsAboutCompanyById(Integer id) {
        return Optional.ofNullable(companyRepository.get(id));
    }

    public void addBeneficialOwnerToCompany(Integer companyId, BeneficialOwner beneficialOwner) {
        getDetailsAboutCompanyById(companyId)
                .map(company -> {
                            company.addBeneficialOwner(beneficialOwner);
                            return company;
                        }
                ).ifPresent(companyRepository::save);
    }
}
