package BookInventory.repository;

import BookInventory.domain.Librarian;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/02.
 */
public interface LibrarianRepository extends CrudRepository<Librarian,Long> {
}
