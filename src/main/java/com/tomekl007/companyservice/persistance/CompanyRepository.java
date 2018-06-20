package com.tomekl007.companyservice.persistance;

import com.tomekl007.companyservice.domain.company.Company;

import java.util.Collection;

public interface CompanyRepository {
    Company get(Integer id);

    void save(Company company);

    Collection<Company> getAllCompanies();
}
