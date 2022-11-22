package LibraryManagement.dto;

import java.util.ArrayList;
import java.util.List;

import LibraryManagement.model.Author;
import LibraryManagement.model.Book;
import LibraryManagement.model.Loan;
import LibraryManagement.model.Student;

public class DataTransferObjectFactory {

	public AuthorDTO convertToDTO(Author author) {
		AuthorDTO authorDto = new AuthorDTO(author);

		authorDto.setBooks(createBookDto(author.getBooks()));

		return authorDto;
	}

	public List<AuthorDTO> convertToDTO(List<Author> authors) {
		List<AuthorDTO> authorsDto = new ArrayList<>();
		for (Author author : authors) {
			AuthorDTO authortoDto = new AuthorDTO(author);
			authortoDto.setBooks(createBookDto(author.getBooks()));
			authorsDto.add(authortoDto);
		}

		return authorsDto;
	}

	public BookDTO createBookDto(Book book) {
		return new BookDTO(book);
		
	}

	public List<BookDTO> createBookDto(List<Book> books) {
		List<BookDTO> bookdto = new ArrayList<>();

		for (Book book : books) {
			BookDTO booktodto = new BookDTO(book);
			bookdto.add(booktodto);

		}
		return bookdto;
	}
	
	public StudentDTO createStudentDto(Student student) {
		return new StudentDTO(student);
	}
	
	public LoanDTO createLoanDto(Loan loan) {
		LoanDTO loanDto = new LoanDTO(loan);
		loanDto.setBook(createBookDto(loan.getBook()));
		loanDto.setStudent(createStudentDto(loan.getStudent()));
		
		return loanDto;
	}
}
