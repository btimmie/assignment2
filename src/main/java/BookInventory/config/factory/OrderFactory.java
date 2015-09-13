package BookInventory.config.factory;

import BookInventory.domain.InventoryItem;
import BookInventory.domain.Order;
import BookInventory.domain.Supplier;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class OrderFactory {
        public static Order createOrder(int quantity,Map<String,String> values,
                                    List<InventoryItem> inventoryItemList){

        Order order = new Order
                .Builder(values.get("code"))
                .description(values.get("description"))
                .quantity(quantity)
                .build();
        return order;
    }
}
