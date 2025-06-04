package org.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;

public class Connector{
    final StandardServiceRegistry registry;
    SessionFactory sessionFactory;
    public Connector() {
        registry = new StandardServiceRegistryBuilder()
                .configure(new File("src/main/resources/hibernate.cfg.xml")) // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
