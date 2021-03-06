package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ManagerBDTest {

    ManagerBdSQL managerBD = new ManagerBdSQL();

    @BeforeEach
    public void setup() {
        managerBD.clean();

        managerBD.addUser("test", "test");
        managerBD.addUser("test1", "test1");
        managerBD.addUser("test2", "test2");
    }

    @Test
    public void shouldNotAdd() {

        assertThrows(SQLException.class, () -> managerBD.addUser("test", "test"));
    }

    @Test
    public void shouldClean() {
        managerBD.clean();
    }

    @Test
    public void shouldGetUsers() {
        System.out.println(managerBD.getUsers());
    }

    @Test
    public void addUsers() {
        System.out.println(managerBD.getUsers());
    }
}