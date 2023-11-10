package etf.webshop.model.requests;

import jakarta.validation.constraints.NotBlank;

public class ItemAttributeRequest {
	private int itemId;
	private int attributeId;
	@NotBlank(message="Value cannot be blank!")
	private String value;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
