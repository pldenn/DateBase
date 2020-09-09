import domain.User;
import driver.HibernateDriver;
import org.hibernate.Session;

public class HibernateManager {

        public void addUser(User user){

        Session session = new HibernateDriver().getSessionFactory().openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

        public Object getUser(int id){

                Session session = new HibernateDriver().getSessionFactory().openSession();
                session.beginTransaction();

               Object user1 = session.get(User.class, id);

                session.getTransaction().commit();
                session.close();

                return user1;
        }
}
