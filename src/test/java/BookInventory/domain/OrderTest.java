package BookInventory.domain;

import BookInventory.config.factory.OrderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createOrder() throws Exception {
        List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();
        Map<String,String> values = new HashMap<String, String>();

        values.put("code","007123");
        values.put("description","Urgent order for a vey special client");

        Order order = OrderFactory
                .createOrder(20,values,inventoryItemList);

        Assert.assertEquals("Urgent order for a vey special client",order.getDescription());
    }
    @Test
    public void updateOrder() throws Exception {
        /*
        List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();
        Map<String,String>values = new HashMap<String, String>();

        values.put("code","CNA007");
        values.put("name","CNA");
        values.put("address","54 Main Road Observatory");

        Supplier supplier = SupplierFactory
                .createSuplier(values,inventoryItemList);

        Supplier newSupplier = new Supplier
                .Builder(supplier.getCode())
                .copy(supplier)
                .name("CCMA").build();
        Assert.assertEquals("CNA007",newSupplier.getCode());
        Assert.assertEquals("CCMA",newSupplier.getName());
        Assert.assertEquals("CNA",supplier.getName());
    }
         */
        List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();
        Map<String,String> values = new HashMap<String, String>();

        values.put("code","007123");
        values.put("description","Urgent order for a vey special client");

        Order order = OrderFactory
                .createOrder(20,values,inventoryItemList);

        Order newOrder = new Order
                .Builder(order.getCode())
                .copy(order)
                .description("Urgent order for a vey special client")
                .quantity(21)
                .build();
        Assert.assertEquals("007123",newOrder.getCode());
        Assert.assertEquals("Urgent order for a vey special client",newOrder.getDescription());
        Assert.assertEquals(21,newOrder.getQuantity());
        Assert.assertEquals(20,order.getQuantity());
    }
}