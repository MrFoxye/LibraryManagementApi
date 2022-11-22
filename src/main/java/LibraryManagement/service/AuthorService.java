package LibraryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	@Autowired
	private BookService bookService;
	
	//@Autowired
	//private AuthorRepository authorRepository;
	
	/**public AuthorDto findByFirstName(String firstName) {
		List<AuthorDTO> authorsDto = new ArrayList<>();
		List<Author> authors = authorRepository.findAll();
		
		
		
	}**/
	
	

}
