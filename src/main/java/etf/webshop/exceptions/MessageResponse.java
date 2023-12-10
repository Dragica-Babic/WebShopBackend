package etf.webshop.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class MessageResponse {
	private Date timestamp;
	private String error;

	public MessageResponse(String errorMessage) {
	    this.setTimestamp(new Date());
	    this.error = errorMessage;
	  }

}