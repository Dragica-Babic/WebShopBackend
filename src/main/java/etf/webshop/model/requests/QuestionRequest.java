package etf.webshop.model.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuestionRequest {
	@NotBlank(message="Question cannot be blank!")
	private String question;
	private String answer;
	private int userId;
	private int itemId;
}
