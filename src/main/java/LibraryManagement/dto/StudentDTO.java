package LibraryManagement.dto;

import LibraryManagement.model.Adress;
import LibraryManagement.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {
	
	private String name;
	
	private Adress adress;
	
	public StudentDTO(Student student) {
		this.name = student.getName();
		this.adress = student.getAdress();
	}
}
