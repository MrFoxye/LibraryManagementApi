package LibraryManagement.dto;

import java.util.List;

import LibraryManagement.model.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO {
	
	private String firstname;
	
	private String lastname;
	
	private List<?> books;
	
	public AuthorDTO(Author author) {
		this.firstname = author.getFirstName();
		this.lastname = author.getLastName();
		this.books = author.getBooks();
	}

}
