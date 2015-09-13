package BookInventory.repository;

import BookInventory.domain.Manager;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/02.
 */
public interface ManagerRepository extends CrudRepository<Manager,Long> {
}
