package service;

import model.Company;
import repository.CompanyRepo;
import java.util.List;

public class CompanyService implements CrudService<Company> {
    CompanyRepo companyRepo=new CompanyRepo();
    @Override
    public void create(Company company) {
        companyRepo.create(company);
    }
    @Override
    public Company read(Long id) {
        return companyRepo.read(id);
    }
    @Override
    public void update(Long id, Company company) {
        companyRepo.update(id,company);
    }
    @Override
    public void delete(Long id) {
        companyRepo.delete(id);
    }
    @Override
    public List<Company> getAll() {
        return companyRepo.getAll();
    }
    public List<Company> getAll(int offset, int perPage, String sortColum) {
        return companyRepo.get(offset,perPage,sortColum);
    }
}