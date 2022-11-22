package LibraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LibraryManagement.model.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

}
