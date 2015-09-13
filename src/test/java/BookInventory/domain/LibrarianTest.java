package BookInventory.domain;

import BookInventory.config.factory.LibrarianFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LibrarianTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createLibrarian() throws Exception{
        Map<String,String> values = new HashMap<String,String>();

        values.put("code","A12B");
        values.put("fistName","Junaid");
        values.put("lastName","Du Plessis");

        Librarian librarian = LibrarianFactory
                .createLibrarian(values);

        Assert.assertEquals("A12B",librarian.getCode());
    }

    @Test
    public void updateLibrarian() throws Exception {
        Map<String, String> values = new HashMap<String, String>();

        values.put("code", "A12B");
        values.put("fistName", "Junaid");
        values.put("lastName", "Du Plessis");

        Librarian librarian = LibrarianFactory
                .createLibrarian(values);

        Librarian newLibrarian = new Librarian
                .Builder(librarian.getCode())
                .firstName("Junaid")
                .lastName("Diggles")
                .build();

        assertEquals("A12B", librarian.getCode());
        assertEquals("A12B", newLibrarian.getCode());
        assertEquals("Du Plessis",librarian.getLastName());
        assertEquals("Diggles",newLibrarian.getLastName());
    }
}