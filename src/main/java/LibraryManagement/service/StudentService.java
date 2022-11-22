package LibraryManagement.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LibraryManagement.model.Student;
import LibraryManagement.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	

}
