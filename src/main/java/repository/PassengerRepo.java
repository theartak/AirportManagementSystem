package repository;

import service.AirportSessionFactory;
import model.*;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.List;

public class PassengerRepo implements CrudRepo<Passenger> {
    public void create(Passenger passenger) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        session.save(passenger);
        session.getTransaction().commit();
        session.close();
    }

    public Passenger read(Long id) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Passenger passenger = session.get(Passenger.class, id);
        session.getTransaction().commit();
        session.close();
        return passenger;
    }

    @Override
    public void update(Long id, Passenger passenger) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Passenger psg = session.get(Passenger.class, id);
        psg.setName(passenger.getName());
        psg.setPhone(passenger.getPhone());
        psg.setAddress(passenger.getAddress());
        session.update(psg);
    }

    @Override
    public void delete(Long id) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        session.remove(session.find(Passenger.class,id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Passenger> getAll() {
        Session session= AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from Passenger", Passenger.class);
        List<Passenger> passengers=  query.getResultList();
        session.getTransaction().commit();
        session.close();
        return passengers;
    }

    public List<Passenger> getAll(int offset, int perPage, String sortColum){
        Session session= AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        String sql="select p from Passenger p order by p."+sortColum+" Desc";
        Query query=session.createQuery(sql);
        query.setFirstResult(offset);
        query.setMaxResults(perPage);
        List<Passenger> passengers=query.getResultList();
        return  passengers;

    }
}