package service;

import model.*;
import org.hibernate.cfg.Configuration;

public class AirportSessionFactory {
    private static org.hibernate.SessionFactory factory;

    private AirportSessionFactory() {

    }

    public static org.hibernate.SessionFactory getFactory() {
        if (factory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Company.class);
            configuration.addAnnotatedClass(Passenger.class);
            configuration.addAnnotatedClass(Trip.class);
            configuration.addAnnotatedClass(PassInTrip.class);
            factory = configuration.buildSessionFactory();

        }
        return factory;
    }
}