package etf.webshop.specification;

public class ItemSearchCriteria {
	private Integer categoryId;
	private String searchTerm;
	private String location;
	private Boolean used;
	private Double lowerPriceLimit;
    private Double upperPriceLimit;
    private Boolean isActive=true;
    private Boolean isDeleted=false;
    
    public ItemSearchCriteria() {super();}
    
	public ItemSearchCriteria(Integer categoryId, String searchTerm, String location, Boolean used,
			Double lowerPriceLimit, Double upperPriceLimit, Boolean isActive, Boolean isDeleted) {
		super();
		this.categoryId = categoryId;
		this.searchTerm = searchTerm;
		this.location = location;
		this.setUsed(used);
		this.lowerPriceLimit = lowerPriceLimit;
		this.upperPriceLimit = upperPriceLimit;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getLowerPriceLimit() {
		return lowerPriceLimit;
	}

	public void setLowerPriceLimit(Double lowerPriceLimit) {
		this.lowerPriceLimit = lowerPriceLimit;
	}

	public Double getUpperPriceLimit() {
		return upperPriceLimit;
	}

	public void setUpperPriceLimit(Double upperPriceLimit) {
		this.upperPriceLimit = upperPriceLimit;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}
	
	
    
}
