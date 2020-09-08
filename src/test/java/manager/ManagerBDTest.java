package manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerBDTest {

    @Test
    public void shouldTestAdd(){
        ManagerBD managerBD = new ManagerBD();
        managerBD.addUser("test","test");

    }

}