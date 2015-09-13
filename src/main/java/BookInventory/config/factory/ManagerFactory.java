package BookInventory.config.factory;

import BookInventory.domain.Librarian;
import BookInventory.domain.Manager;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class ManagerFactory {
    public static Manager createManager(Map<String,String> values){

        Manager manager = new Manager
                .Builder(values.get("code"))
                .firstName(values.get("firstName"))
                .lastName(values.get("lastName"))
                .build();
        return manager;
    }
}
