package etf.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import etf.webshop.model.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Modifying
	@Query("update Category c set c.isDeleted=true where c.id = :id")
	void deleteItem( Integer id);
}
