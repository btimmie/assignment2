package BookInventory.domain;

import BookInventory.config.factory.AjustmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjustmentTest {

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void creatAjustment() throws Exception{
        List<Employee> employeeList = new ArrayList<Employee>();
        Map<String,String> values = new HashMap<String,String>();


        values.put("itemName","Lord of the rings");
        values.put("code","123abc");

        Ajustment ajustment = AjustmentFactory
                .createAjustment(15,values,employeeList);

        Assert.assertEquals("123abc",ajustment.getCode());
    }

    @Test
    public void updateAjustment() throws Exception {
        List<Employee> employeeList = new ArrayList<Employee>();
        Map<String, String> values = new HashMap<String, String>();

        values.put("itemName","Lord of the rings");
        values.put("code","123abc");

        Ajustment ajustment = AjustmentFactory
                .createAjustment(15, values, employeeList);

        Ajustment newAjustment = new Ajustment
                .Builder(ajustment.getItemName())
                .copy(ajustment)
                .amount(10)
                .build();

        Assert.assertEquals("123abc",newAjustment.getCode());
        Assert.assertEquals("123abc",newAjustment.getCode());
        Assert.assertEquals(10,newAjustment.getAmount());
        Assert.assertEquals(15,ajustment.getAmount());
    }
}