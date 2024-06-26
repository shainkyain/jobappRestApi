package com.devil.Job.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Boolean addCompany(Company company) {
        companyRepository.save(company);
        return true;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteCompanyById(Long id) {
      if(companyRepository.findById(id) == null){
          return false;
      }else{
          companyRepository.deleteById(id);
             return true;
      }
    }

    @Override
    public Boolean updateCompanyById(Long id, Company updatedCompany) {
        Company company = companyRepository.findById(id).orElse(null);
        if(company!= null && updatedCompany != null){
                company.setTitle(updatedCompany.getTitle());
                company.setDescription(updatedCompany.getDescription());
                companyRepository.save(company);
            return true;
        }else return false;

    }
}
