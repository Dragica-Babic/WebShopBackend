package etf.webshop.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serial;


public class ResourceNotFoundException extends HttpException {
	@Serial
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super(HttpStatus.NOT_FOUND, null);
	}
	
	public ResourceNotFoundException(Object data) {
		super(HttpStatus.NOT_FOUND, data);
	}
}
