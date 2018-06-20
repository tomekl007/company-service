package com.tomekl007.companyservice.persistance;

import com.tomekl007.companyservice.domain.company.Company;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CompanyRepositoryInMemory implements CompanyRepository {
    private final Map<Integer, Company> db = new LinkedHashMap<>();

    @Override
    public Company get(Integer id) {
        return db.get(id);
    }

    @Override
    public void save(Company company) {
        db.put(company.getCompanyId(), company);

    }

    @Override
    public Collection<Company> getAllCompanies() {
        return db.values();
    }
}
