package BookInventory.config.factory;

import BookInventory.domain.Consumtion;
import BookInventory.domain.Customer;
import BookInventory.domain.Librarian;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class CustomerFactory {
    public static Customer createCustomer(Map<String, String> values,List<Consumtion> consumtionList) {

        Customer customer = new Customer
                .Builder(values.get("code"))
                .firstName(values.get("firstName"))
                .lastName(values.get("lastName"))
                .consumtionList(consumtionList)
                .build();
        return customer;
    }
}
