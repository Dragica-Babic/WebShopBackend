package etf.webshop.model.dto;

import lombok.Data;

@Data
public class ItemDTO {
	private Integer id;
	private String title;
	private String description;
	private Double price;
	private Boolean used;
	private String location;
	private Integer categoryId;
	private Integer userId;
	private Integer customerId;
	private String image;

}
