package etf.webshop.model.requests;

import jakarta.validation.constraints.NotBlank;

public class MessageRequest {
	@NotBlank(message="Message text cannot be blank!")
	private String text;
	private boolean isRead;
	private int userId;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
