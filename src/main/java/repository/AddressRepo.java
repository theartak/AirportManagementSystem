package repository;

import service.AirportSessionFactory;
import model.*;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.*;


public class AddressRepo implements CrudRepo<Address> {
    public void create(Address address) {

        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();

    }

    public Address read(Long id) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Address adrs = session.find(Address.class, id);
        session.getTransaction().commit();
        session.close();
        return adrs;
    }

    public void update(Long id, Address address) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Address adrs = session.find(Address.class, id);
        adrs.setCity(address.getCity());
        adrs.setCountry(address.getCountry());
        session.update(adrs);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Long id) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        session.remove(session.find(Address.class, id));
        session.getTransaction().commit();
        session.close();
    }

    public List<Address> getAll() {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Address", Address.class);
        List<Address> addresses = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return addresses;
    }

    public List<Address> get(int offset, int perPage, String sort) {

        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        String sql = "select a from Address a order by a." + sort + " Desc";
        Query query = session.createQuery(sql).setFirstResult(offset).setMaxResults(perPage);
        List<Address> addresses = query.getResultList();
        session.close();
        return addresses;
    }
}