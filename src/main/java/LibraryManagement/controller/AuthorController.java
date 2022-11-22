package LibraryManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LibraryManagement.dto.AuthorDTO;
import LibraryManagement.dto.DataTransferObjectFactory;
import LibraryManagement.exception.ResourceNotFoundException;
import LibraryManagement.model.Author;
import LibraryManagement.repositories.AuthorRepository;

@RestController
@RequestMapping(value = "authors")
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private DataTransferObjectFactory dtoFactory;
	
	@GetMapping
	public ResponseEntity<List<AuthorDTO>> findAll() {
		List<Author> authors = authorRepository.findAll();
		List<AuthorDTO> authorsDto = dtoFactory.convertToDTO(authors);
		if(authors != null) {
			return ResponseEntity.status(HttpStatus.OK).body(authorsDto);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>findById(@PathVariable("id") long id){
		Author author = authorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Author not found with id = " + id));
			
		return ResponseEntity.status(HttpStatus.OK).body(author);
		
	}
	@PostMapping
	public Author createAuthor(@RequestBody @Valid Author author) {
		return authorRepository.save(author);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteAuthor(@RequestBody Author author) {
		
	}

}
