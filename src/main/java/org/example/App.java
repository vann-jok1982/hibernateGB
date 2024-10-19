package org.example;

import org.example.model.PersonGB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(PersonGB.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            PersonGB personGB1=new PersonGB("Ivan",42);
            PersonGB personGB2=new PersonGB("Sergey",46);
            PersonGB personGB3=new PersonGB("Petr",40);

            session.persist(personGB1);
            session.persist(personGB2);
            session.persist(personGB3);

            PersonGB person = session.get(PersonGB.class, 1);
            PersonGB person2 = session.get(PersonGB.class, 2);
            PersonGB person3 = session.get(PersonGB.class, 3);
            System.out.println(person.getName()+","+person.getAge());
            System.out.println(person2.getName()+","+person2.getAge());
            System.out.println(person3.getName()+","+person3.getAge());

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
