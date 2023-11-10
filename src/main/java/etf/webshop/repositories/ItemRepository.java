package etf.webshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import etf.webshop.model.entities.Item;

import jakarta.annotation.Nullable;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	Page<Item> findAll(@Nullable Specification<Item> spec, Pageable page);

	List<Item> findAllByIsDeletedFalse();

	Page<Item> findAllByUserIdAndIsDeletedFalseAndIsActiveTrue(int id, Pageable page);
	
	Page<Item> findAllByUserIdAndIsDeletedFalseAndIsActiveFalse(int id, Pageable page);
	
	Page<Item> findAllByCustomerId(int id, Pageable page);
	
	@Modifying
	@Query("update Item i set i.isDeleted=true, i.isActive=false where i.id = :id")
	int deleteItem(Integer id);
	
	@Modifying
	@Query("update Item i set i.isActive=false, i.customerId=:customerId where i.id=:id")
	int buyItem(int id, Integer customerId);

}
