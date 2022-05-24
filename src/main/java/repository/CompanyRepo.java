package repository;

import service.AirportSessionFactory;
import model.*;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class CompanyRepo implements CrudRepo<Company> {
    public void create(Company company) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Company read(Long id) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Company cmp = session.find(Company.class, id);
        session.getTransaction().commit();
        session.close();
        return cmp;
    }

    @Override
    public void update(Long id, Company company) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Company cmp = session.find(Company.class, id);
        cmp.setDate(company.getDate());
        cmp.setName(company.getName());
        session.update(cmp);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        session.remove(session.find(Company.class, id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Company> getAll() {
        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Company", Company.class);
        List<Company> companies = query.getResultList();
        return companies;
    }

    public List<Company> get(int offset, int perPage, String sort) {

        Session session = AirportSessionFactory.getFactory().openSession();
        session.beginTransaction();
        String sql = "select c from Company c order by c." + sort + " Desc";
        Query query = session.createQuery(sql).setFirstResult(offset).setMaxResults(perPage);
        List<Company> companies = query.getResultList();
        session.close();
        return companies;
    }
}