package telran.java38.forum.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6519974096714698715L;

	public PostNotFoundException() {
		
	}
	
	public PostNotFoundException(String id) {
		super("Post ID " + id + "not found");
	}
	
}
