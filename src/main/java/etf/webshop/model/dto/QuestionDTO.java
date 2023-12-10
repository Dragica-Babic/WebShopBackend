package etf.webshop.model.dto;

import lombok.Data;

@Data
public class QuestionDTO {
	private int id;
	private String question;
	private String answer;
	private String userUsername;
	private int itemId;
}
