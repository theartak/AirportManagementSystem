package service;

import model.Address;
import repository.AddressRepo;
import java.util.List;

public class AddressService implements CrudService<Address> {
    AddressRepo addressRepo = new AddressRepo();
    public void create(Address address) {
        addressRepo.create(address);
    }
    public Address read(Long id) {
        return addressRepo.read(id);
    }
    public void update(Long id, Address address) {
        addressRepo.update(id, address);
    }
    public void delete(Long id) {
        addressRepo.delete(id);
    }
    public List<Address> getAll() {
        return addressRepo.getAll();
    }
    public List<Address> getAll(int offset,int perPage,String sortColum){
        return addressRepo.get(offset,perPage,sortColum);
    }
}