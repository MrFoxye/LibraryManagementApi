package LibraryManagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LibraryManagement.model.Book;
import LibraryManagement.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	public Book save(Book book) {
			return bookRepository.save(book);
		
	}
	
	
	


}
