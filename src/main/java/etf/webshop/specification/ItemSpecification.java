package etf.webshop.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import etf.webshop.model.entities.Item;

import jakarta.persistence.criteria.Predicate;

public class ItemSpecification {
	
	public static Specification<Item> createItemSpecification(ItemSearchCriteria criteria){
		return (root, cq, cb)->{
			List<Predicate> predicates=new ArrayList<>();
			if(criteria.getCategoryId()!=null)
				predicates.add(cb.equal(root.get("category").get("id"), criteria.getCategoryId()));
			
			predicates.add(cb.equal(root.get("isDeleted"), criteria.getIsDeleted()));
			predicates.add(cb.equal(root.get("isActive"), criteria.getIsActive()));
			
			if(criteria.getSearchTerm()!=null) {
				predicates.add(cb.like(cb.lower(root.get("title")), "%"+ criteria.getSearchTerm().toLowerCase()+"%"));
				
			}
			if(criteria.getLocation()!=null)
				predicates.add(cb.like(cb.lower(root.get("location")),"%"+ criteria.getLocation().toLowerCase()+"%"));
			System.out.println(criteria.getLowerPriceLimit());
			if(null!=criteria.getLowerPriceLimit()) {
				predicates.add(cb.greaterThan(root.get("price"), criteria.getLowerPriceLimit()));
			}
			if(null!=criteria.getUpperPriceLimit())
				predicates.add(cb.lessThan(root.get("price"), criteria.getUpperPriceLimit()));
			
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

}
