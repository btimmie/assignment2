package BookInventory.config.factory;

import BookInventory.domain.InventoryItem;
import BookInventory.domain.Supplier;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class SupplierFactory {
     public static Supplier createSuplier(Map<String,String> values,
                                         List<InventoryItem>inventoryItemList){
        Supplier supplier = new Supplier
                .Builder(values.get("code"))
                .name(values.get("name"))
                .address(values.get("address"))
                .inventoryItemList(inventoryItemList)
                .build();
        return supplier;
    }
}
