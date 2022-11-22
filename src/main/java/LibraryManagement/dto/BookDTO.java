package LibraryManagement.dto;

import LibraryManagement.model.Author;
import LibraryManagement.model.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO {

	private String name;
	
	private String cover;
	
	private Double price;
	
	private String genre;
	
	private Author author;
	
	
	public BookDTO(Book book) {
		this.name = book.getName();
		this.cover = book.getCover();
		this.price = book.getPrice();
		this.genre = book.getGenre();
		this.author = book.getAuthor();
	}
	
}
