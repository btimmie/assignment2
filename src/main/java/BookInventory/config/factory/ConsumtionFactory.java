package BookInventory.config.factory;

import BookInventory.domain.Consumtion;
import BookInventory.domain.Order;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class ConsumtionFactory {
    public static Consumtion createConsumtion(int quantity, Map<String,String> values){

        Consumtion consumtion = new Consumtion
                .Builder(values.get("code"))
                .quantity(quantity)
                .build();

        return consumtion;
    }

}
