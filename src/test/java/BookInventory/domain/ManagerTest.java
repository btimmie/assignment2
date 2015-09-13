package BookInventory.domain;

import BookInventory.config.factory.LibrarianFactory;
import BookInventory.config.factory.ManagerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ManagerTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createManager() throws Exception{
        Map<String,String> values = new HashMap<String,String>();

        values.put("code","D15C");
        values.put("fistName","Felicity");
        values.put("lastName","Smoak");

        Manager manager = ManagerFactory
                .createManager(values);

        Assert.assertEquals("D15C", manager.getCode());
    }

    @Test
    public void updateLibrarian() throws Exception {
        Map<String, String> values = new HashMap<String, String>();

        values.put("code","D15C");
        values.put("fistName","Felicity");
        values.put("lastName","Smoak");

        Manager manager = ManagerFactory
                .createManager(values);

        Manager newManager = new Manager
                .Builder(manager.getCode())
                .firstName("Felicity")
                .lastName("Queen")
                .build();

        assertEquals("D15C", manager.getCode());
        assertEquals("D15C", newManager.getCode());
        assertEquals("Smoak",manager.getLastName());
        assertEquals("Queen",newManager.getLastName());
    }
}