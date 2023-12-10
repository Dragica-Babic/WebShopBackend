package etf.webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import etf.webshop.model.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
