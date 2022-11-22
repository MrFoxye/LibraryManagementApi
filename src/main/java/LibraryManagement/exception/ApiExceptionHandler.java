package LibraryManagement.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException){
		ProblemDetails rfnDetails = ProblemDetails
		.builder()
		.timestamp(LocalDate.now())
		.status(HttpStatus.NOT_FOUND.value())
		.title("Resource not found")
		.detail(rfnException.getMessage())
		.DeveloperMessage(rfnException.getClass().getName()).build();
		
		return new ResponseEntity<>( rfnDetails, HttpStatus.NOT_FOUND);
		
	}
	
	
}
