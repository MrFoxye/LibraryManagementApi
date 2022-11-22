package LibraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LibraryManagement.model.Author;

@Repository
public interface AuthorRepository  extends JpaRepository<Author, Long>{

}
