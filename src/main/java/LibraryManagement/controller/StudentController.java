package LibraryManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LibraryManagement.dto.StudentDTO;
import LibraryManagement.exception.ResourceNotFoundException;
import LibraryManagement.model.Student;
import LibraryManagement.repositories.StudentRepository;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<StudentDTO> findAll() {
		List<Student> students = studentRepository.findAll();
		List<StudentDTO>studentsDto = new ArrayList<>();
		
		for(Student student:students) {
			
			StudentDTO studentToDto = new StudentDTO(student);
			studentsDto.add(studentToDto);
		}
		return studentsDto;
		
	}
	/**@GetMapping("/{name}")
	public Student findByName(@PathVariable String name) {
		
		return null;
	}**/
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable long id) {
		Student student = studentRepository
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Student not found with id = " + id));
		return ResponseEntity.status(HttpStatus.OK).body(student);
		
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		
		studentRepository.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable long id) {
		
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			studentRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	
}
