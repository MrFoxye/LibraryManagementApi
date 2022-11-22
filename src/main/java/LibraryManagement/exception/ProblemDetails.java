package LibraryManagement.exception;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(value = Include.NON_NULL)
@Getter
@Builder
@AllArgsConstructor
public class ProblemDetails{
	
	private String title;
	private Integer status;
	private String type;
	private String detail;
	private LocalDate timestamp;
	private String DeveloperMessage;
	
	

}
