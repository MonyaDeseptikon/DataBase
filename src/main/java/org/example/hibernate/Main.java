package org.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;

public class Main {
    public static void main(String[] args) {


        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(new File("src/main/resources/hibernate.cfg.xml")) // configures settings from hibernate.cfg.xml
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
//        Magic magic = new Magic();
        Magic magic = new Magic("Волшебная стрела", 10, 0, 0);
        session.beginTransaction();
        session.persist(magic);
        session.getTransaction().commit();
        session.close();
    }
}