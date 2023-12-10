package etf.webshop.model.requests;

import lombok.Data;

@Data
public class UserRequest {
	private String name;
	private String surname;
	private String username;
	private String password;
	private String email;
	private String address;
}
