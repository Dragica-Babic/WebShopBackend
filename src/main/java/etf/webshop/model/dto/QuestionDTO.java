package etf.webshop.model.dto;

public class QuestionDTO {
	private int id;
	private String question;
	private String answer;
	private String userAccountUsername;
	private String userAvatar;
	private int itemId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getUserAccountUsername() {
		return userAccountUsername;
	}
	public void setUserAccountUsername(String userAccountUsername) {
		this.userAccountUsername = userAccountUsername;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	
}
