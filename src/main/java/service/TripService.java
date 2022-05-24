package service;

import model.Trip;
import org.hibernate.Session;
import repository.TripRepo;
import javax.persistence.Query;
import java.util.List;

public class TripService {
    TripRepo tripRepo = new TripRepo();

    public void create(Trip trip) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();
    }

    public Trip read(Long id) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Trip trip = session.find(Trip.class, id);
        session.getTransaction().commit();
        session.close();
        return trip;
    }

    public void update(Long id, Trip trip) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Trip tp = session.find(Trip.class, id);
        tp.setTownTo(trip.getTownTo());
        tp.setTownFrom(trip.getTownFrom());
        tp.setTimeOut(trip.getTimeOut());
        tp.setTimeIn(trip.getTimeIn());
        session.update(tp);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Long id) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        session.remove(session.find(Trip.class, id));
        session.getTransaction().commit();
        session.close();
    }

    public List<Trip> getAll() {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Trip", Trip.class);
        List<Trip> trips = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return trips;
    }
}