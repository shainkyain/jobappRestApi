package com.devil.Job.company;

import jdk.jfr.Registered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
       return new ResponseEntity<>( companyService.getAllCompanies(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Boolean> addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return new ResponseEntity<>(true , HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
    return new ResponseEntity<>( companyService.getCompanyById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCompanyById(@PathVariable Long id){
        companyService.deleteCompanyById(id);
        return new ResponseEntity<>(true , HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateCompanyById(@PathVariable Long id ,@RequestBody Company updatedCompany){
        companyService.updateCompanyById(id , updatedCompany);
        return new ResponseEntity<>(true , HttpStatus.OK);
    }

}
