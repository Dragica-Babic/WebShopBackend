package etf.webshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import etf.webshop.model.entities.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

	List<Attribute> findByCategoryId(int id);
	
}
