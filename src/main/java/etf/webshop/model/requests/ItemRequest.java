package etf.webshop.model.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ItemRequest {
	@NotBlank(message="Title cannot be blank!")
	@Size(min=3, max=25)
	private String title;
	@NotBlank(message="Description cannot be blank!")
	@Size(min=3)
	private String description;
	@Min(value=0, message="Min value for price is 0")
	private Double price;
	
	private boolean isUsed;
	@NotBlank(message="Location cannot be blank!")
	@Size(min=3, max=25)
	private String location;
	private Integer categoryId;
	private Integer userId;
	private boolean isActive;
	private String image;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isNew) {
		this.isUsed = isNew;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
