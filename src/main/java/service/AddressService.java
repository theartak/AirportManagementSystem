package service;

import dao.daoImpl.AddressDaoImpl;
import model.Address;

import java.util.Set;

public class AddressService {
    private AddressDaoImpl addressDao = new AddressDaoImpl();

    public void create(String country, String city) {
        addressDao.create(new Address(country, city));
    }

    public Address findId(int id) {
        return addressDao.findByID(id);
    }

    public void delete(int id) {
        addressDao.deleteById(id);
    }

    public void update(int id, String country, String city) {
        addressDao.update(id, new Address(country, city));
    }

    public Set<Address> findAll() {
        return addressDao.findAll();
    }
}