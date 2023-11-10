package etf.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import etf.webshop.model.entities.Pin;

public interface PinRepository extends JpaRepository<Pin, Integer> {
	
	Pin findByUserId(int id);
}
