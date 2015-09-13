package BookInventory.config.factory;

import BookInventory.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class InventoryItemFactory {
    public static InventoryItem createInventoryItem(Map<String,String> values,
                                            List<Consumtion> consumtionList,List<Return> returnList){

        InventoryItem inventoryItem = new InventoryItem
                .Builder(values.get("code"))
                .name(values.get("name"))
                .description(values.get("description"))
                .build();
        return inventoryItem;

    }
}
