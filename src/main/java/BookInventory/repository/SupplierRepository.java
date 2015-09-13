package BookInventory.repository;

import BookInventory.domain.Supplier;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/02.
 */
public interface SupplierRepository extends CrudRepository<Supplier,Long> {
}
