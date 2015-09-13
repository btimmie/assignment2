package BookInventory.domain;

import BookInventory.config.factory.CustomerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerTest {

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void createCustomer() throws ExportException{
        List<Consumtion> consumtionList = new ArrayList<Consumtion>();
        Map<String,String> values = new HashMap<String,String>();

        values.put("code","98TYT");

        Customer customer = CustomerFactory
                .createCustomer(values,consumtionList);

        Assert.assertEquals("98TYT",customer.getCode());
    }

    @Test
    public void updateCustomer() throws ExportException {
        List<Consumtion> consumtionList = new ArrayList<Consumtion>();
        Map<String, String> values = new HashMap<String, String>();

        values.put("code", "98TYT");
        values.put("firstName","Lexi");
        values.put("lastName","Parker");

        Customer customer = CustomerFactory
                .createCustomer(values, consumtionList);

        Customer newCustomer = new Customer
                .Builder(customer.getCode())
                .firstName("Audrey")
                .lastName("Parker")
                .build();

        Assert.assertEquals("Parker",customer.getLastName());
        Assert.assertEquals("Parker",newCustomer.getLastName());
        Assert.assertEquals("Lexi",customer.getFirstName());
        Assert.assertEquals("Audrey",newCustomer.getFirstName());
    }
}