package etf.webshop.specification;

import lombok.Data;

@Data
public class ItemSearchCriteria {
	private Integer categoryId;
	private String searchTerm;
	private String location;
	private Double lowerPriceLimit;
    private Double upperPriceLimit;
    private Boolean isActive=true;
    private Boolean isDeleted=false;

	public ItemSearchCriteria(Integer categoryId, String searchTerm, String location, Double lowerPriceLimit, Double upperPriceLimit) {
		this.categoryId = categoryId;
		this.searchTerm = searchTerm;
		this.location=location;
		this.lowerPriceLimit=lowerPriceLimit;
		this.upperPriceLimit=upperPriceLimit;
	}


}
