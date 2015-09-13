package BookInventory.repository;

import BookInventory.domain.InventoryItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/02.
 */
public interface InventoryRepository extends CrudRepository<InventoryItem,Long>{
}
