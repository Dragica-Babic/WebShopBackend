package etf.webshop.exceptions;

import java.util.Date;

public class MessageResponse {
	private Date timestamp;
	private String error;

	public MessageResponse(String errorMessage) {
	    this.setTimestamp(new Date());
	    this.error = errorMessage;
	  }

	public String getError() {
		return error;
	}

	public void setError(String errorMessage) {
		this.error = errorMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}