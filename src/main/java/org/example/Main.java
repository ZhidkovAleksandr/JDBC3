package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Entity.Animal;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal();

        dog.setId(1);
        dog.setAge(2);
        dog.setName("Patron");
        dog.setTail(true);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(dog);
        session.getTransaction().commit();
        session.close();

        System.out.println("added to db");

    }
}