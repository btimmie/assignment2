package BookInventory.domain;

import BookInventory.config.factory.ConsumtionFactory;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ConsumtionTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createConsumtion() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        values.put("code","123456");

        Consumtion consumtion = ConsumtionFactory
                .createConsumtion(5,values);

        assertEquals("123456", consumtion.getCode());
    }

    @Test
    public void updateConsumtion() throws Exception{
        Map<String,String> values = new HashMap<String,String>();

        values.put("code","123456");

        Consumtion consumtion = ConsumtionFactory
                .createConsumtion(5,values);

        Consumtion newConsumtion = new Consumtion
                .Builder(consumtion.getCode())
                .copy(consumtion)
                .quantity(6)
                .build();

        assertEquals("123456", consumtion.getCode());
        assertEquals("123456", newConsumtion.getCode());
        assertEquals(6, newConsumtion.getQuantity());
        assertEquals(5, consumtion.getQuantity());
    }
}