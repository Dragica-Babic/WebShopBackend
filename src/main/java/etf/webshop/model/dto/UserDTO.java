package etf.webshop.model.dto;

public class UserDTO {
	private int id;
	private int accountId;
	private String email;
	private String city;
	private String accountName;
	private String accountSurname;
	private String accountUsername;
	private String accountPassword;
	private String avatar;
	private boolean isActivated;
	
	
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
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountSurname() {
		return accountSurname;
	}
	public void setAccountSurname(String accountSurname) {
		this.accountSurname = accountSurname;
	}
	public String getAccountUsername() {
		return accountUsername;
	}
	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActivated() {
		return isActivated;
	}
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	
	
}
