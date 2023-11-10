package etf.webshop.model.dto;

public class ItemAttributeDTO {
	private int id;
	private int itemId;
	private String attributeTitle;
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getAttributeTitle() {
		return attributeTitle;
	}
	public void setAttributeTitle(String attributeTitle) {
		this.attributeTitle = attributeTitle;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
