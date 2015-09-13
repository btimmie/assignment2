package BookInventory.domain;

import BookInventory.config.factory.SupplierFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplierTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateSupplier() throws Exception{
        List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();
        Map<String,String>values = new HashMap<String, String>();

        values.put("code","CNA007");
        values.put("name","CNA");
        values.put("address","54 Main Road Observatory");

        Supplier supplier = SupplierFactory
                .createSuplier(values,inventoryItemList);

        Assert.assertEquals("CNA",supplier.getName());
    }
    @Test
    public void testUpdateSupplier() throws Exception{
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
}