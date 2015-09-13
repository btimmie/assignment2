package BookInventory.config.factory;

import BookInventory.domain.Customer;
import BookInventory.domain.Return;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class ReturnFactory {
    public static Return createReturn(int quantity, Map<String,String> values,List<Customer> customerList){

        Return ret = new Return
                .Builder(values.get("code"))
                .quantity(quantity)
                .build();
        return ret;
    }
}
