package com.devil.Job.company;

import com.devil.Job.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Boolean addCompany(Company company);
    Company getCompanyById(Long id);
    Boolean deleteCompanyById(Long id);
    Boolean updateCompanyById(Long id , Company updatedCompany);

}
