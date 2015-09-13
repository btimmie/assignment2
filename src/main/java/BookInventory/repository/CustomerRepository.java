package BookInventory.repository;

import BookInventory.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/02.
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
