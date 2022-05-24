package service;

import model.Passenger;
import repository.PassengerRepo;
import java.util.List;

public class PassengerService implements CrudService<Passenger> {
    PassengerRepo passengerRepo = new PassengerRepo();

    public void create(Passenger passenger) {
        passengerRepo.create(passenger);
    }

    public Passenger read(Long id) {
        return passengerRepo.read(id);
    }

    public void update(Long id, Passenger passenger) {
        passengerRepo.update(id, passenger);
    }

    public void delete(Long id) {
        passengerRepo.delete(id);
    }

    public List<Passenger> getAll() {
        return passengerRepo.getAll();
    }

    public List<Passenger> getAll(int offset, int perPage, String sortColum) {
        return passengerRepo.getAll(offset, perPage, sortColum);
    }
}