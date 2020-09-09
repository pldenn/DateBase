import domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HibernateManagerTest {
        HibernateManager manager = new HibernateManager();

    @Test
    void addUser() {

        User test = new User(5,"test","test");

        manager.addUser(test);
    }

    @Test
    void getUser() {

        manager.getUser(5);
    }
}