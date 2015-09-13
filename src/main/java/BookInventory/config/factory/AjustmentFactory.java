package BookInventory.config.factory;

import BookInventory.domain.Ajustment;
import BookInventory.domain.Employee;
import BookInventory.domain.InventoryItem;
import BookInventory.domain.Order;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class AjustmentFactory {
    public static Ajustment createAjustment(int amount,Map<String,String> values,
                                    List<Employee> employeeList){
        Ajustment ajustment = new Ajustment
                .Builder(values.get("code"))
                .amount(amount)
                .employeeList(employeeList)
                .build();
        return ajustment;
    }
}
