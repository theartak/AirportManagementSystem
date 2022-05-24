package repository;

import service.AirportSessionFactory;
import model.PassInTrip;
import org.hibernate.Session;
import java.util.List;

public class PassInTripRepo implements CrudRepo<PassInTrip> {
    public void create(PassInTrip passInTrip) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        session.save(passInTrip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public PassInTrip read(Long id) {
        return null;
    }

    @Override
    public void update(Long id, PassInTrip passInTrip) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PassInTrip> getAll() {
        return null;
    }
}