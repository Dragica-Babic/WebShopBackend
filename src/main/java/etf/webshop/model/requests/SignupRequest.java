package etf.webshop.model.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignupRequest {
	@NotBlank(message="Name cannot be blank!")
	@Size(min=3, max=25)
	private String name;
	@NotBlank(message="Surname cannot be blank!")
	@Size(min=3, max=25)
	private String surname;
	@NotBlank(message="Username cannot be blank!")
	@Size(min=3, max=25)
	private String username;
	@NotBlank(message="Password cannot be blank!")
	@Size(min=8, max=25)
	private String password;
	@Email
	private String email;
	@NotBlank(message="City cannot be blank!")
	@Size(min=3, max=25)
	private String city;
	private String avatar;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
