package BookInventory.domain;

import BookInventory.config.factory.InventoryItemFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class InventoryItemTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createInventoryItem() throws Exception{
        List<Consumtion> consumtionList = new ArrayList<Consumtion>();
        List<Return> returnList = new ArrayList<Return>();
        Map<String,String> values = new HashMap<String, String>();

        values.put("code","00789");
        values.put("name","Book");
        values.put("description","About a group of four intelligent individuals");

        InventoryItem inventoryItem = InventoryItemFactory
                .createInventoryItem(values,consumtionList,returnList);

        InventoryItem newInventoryItem = new InventoryItem
                .Builder(inventoryItem.getCode())
                .copy(inventoryItem)
                .name("DVD")
                .build();

        Assert.assertEquals("00789",inventoryItem.getCode());
        Assert.assertEquals("00789",newInventoryItem.getCode());
        Assert.assertEquals("DVD",newInventoryItem.getName());
        Assert.assertEquals("Book",inventoryItem.getName());
    }
}