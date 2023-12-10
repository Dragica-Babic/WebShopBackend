package etf.webshop.model.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ItemRequest {
	private String title;
	private String description;
	private Double price;
	private boolean used;
	private String location;
	private Integer categoryId;
	private Integer userId;
	private boolean active;
	private String image;
}
