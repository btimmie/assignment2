package BookInventory.repository;

import BookInventory.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/02.
 */
public interface OrderRepository extends CrudRepository<Order,Long> {
}
