package etf.webshop.model.dto;

import lombok.Data;

@Data
public class UserDTO {
	private int id;
	private String name;
	private String surname;
	private String username;
	private String email;
	private String address;
}
