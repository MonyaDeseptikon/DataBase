package org.example.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Session session = new Connector().getSession();
//
//        Magic magic = new Magic("Волшебная стрела", 10, 0, 0);
//        session.beginTransaction();
//        session.persist(magic);
//        magic = new Magic("Молния", 25, 0, 0);
//        session.persist(magic);
//        magic = new Magic("Каменная кожа", 0, 0, 6);
//        session.persist(magic);
//        magic = new Magic("Реки крови", 20, 6, 0);
//        session.persist(magic);
//        magic = new Magic("Лунная вуаль", 0, 6, 0);
//        session.persist(magic);
//        magic = new Magic("Проклятие", 0, -3, 0);
//        session.persist(magic);
//        magic = new Magic("Лечение", -30, 0, 0);
//        session.persist(magic);
//        session.getTransaction().commit();
//        session.close();

        //достать из базы таблицу
//        Session session2 = new Connector().getSession();
//        List<Magic> books = session2.createQuery("FROM Magic", Magic.class).getResultList();
//        books.forEach(b -> {System.out.println("Book of Magic : " + b);});
//        session2.close();

        //Изменить в таблице
//        try (Session session = new Connector().getSession()) {
//            String hql = "from Magic where id =: id";
//            Query<Magic> query = session.createQuery( hql, Magic.class);
//            query.setParameter("id", 4);
//            Magic magic =query.getSingleResult();
//            System.out.println(magic);
//            magic.setAttBonus(12);
//            magic.setName("Ярость");
//            session.beginTransaction();
//            session.persist(magic);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try (Session session = new Connector().getSession()) {
            Transaction t = session.beginTransaction();
            List<Magic> books = session.createQuery("FROM Magic",
                    Magic.class).getResultList();
//            books.forEach(session::remove); //или так
            books.forEach(b-> {
                session.remove(b);
            });
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


//Удаление по ИД
//Magic magic = new Magic().setId(3);
//        magic.setId(3);
//        deleteByID(session, magic);


    }

    public static <C> void deleteByID(Session session, C object) {

        session.beginTransaction();
        session.remove(object);
        session.getTransaction().commit();
        session.close();
    }


}