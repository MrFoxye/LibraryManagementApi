package LibraryManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LibraryManagement.dto.BookDTO;
import LibraryManagement.dto.DataTransferObjectFactory;
import LibraryManagement.exception.ResourceNotFoundException;
import LibraryManagement.model.Book;
import LibraryManagement.repositories.BookRepository;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	
	
	@Autowired
	private DataTransferObjectFactory dtoFactory;

	@GetMapping
	public List<BookDTO> findAll() {
		
		List<Book> books = bookRepository.findAll();

		List<BookDTO> booksdto = dtoFactory.createBookDto(books);

		return booksdto;
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> findById(@PathVariable long id) {

		Book book = bookRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Book not found with id = " + id));
		
		BookDTO bookDto =dtoFactory.createBookDto(book);

		return ResponseEntity.status(HttpStatus.FOUND).body(bookDto);
	}

	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody @Valid Book book) {
		if (book != null) {

			return ResponseEntity.status(HttpStatus.OK).body(book);

		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
