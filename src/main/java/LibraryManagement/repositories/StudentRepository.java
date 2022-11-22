package LibraryManagement.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import LibraryManagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT student from Student student WHERE name = :name")
	Optional<Student>findByName(@Param("name") String name);
}
