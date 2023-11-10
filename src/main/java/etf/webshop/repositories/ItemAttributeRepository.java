package etf.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import etf.webshop.model.entities.ItemAttribute;

public interface ItemAttributeRepository extends JpaRepository<ItemAttribute, Integer> {
	
	List<ItemAttribute> findAllByItemId(int id);
}
