package BookInventory.config.factory;

import BookInventory.domain.Librarian;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class LibrarianFactory {

    public static Librarian createLibrarian(Map<String,String> values){

        Librarian librarian = new Librarian
                .Builder(values.get("code"))
                .firstName(values.get("firstName"))
                .lastName(values.get("lastName"))
                .build();
        return librarian;
    }
}
