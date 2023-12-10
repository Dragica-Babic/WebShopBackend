package etf.webshop.model.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {

	private String name;
	private String surname;
	private String username;
	private String password;
	private String email;
	private String address;
}
