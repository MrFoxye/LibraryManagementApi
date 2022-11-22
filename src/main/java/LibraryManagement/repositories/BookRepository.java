package LibraryManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import LibraryManagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	
	List<Book>findBookByAuthorFirstName(String Firstname);
	
	@Query("select b from Book b order by b.price asc")
	List<Book> orderByPriceAsc();
	
	@Query("select b from Book b order by b.price desc")
	List<Book> orderByPriceDesc();
	
	@Query("select b from Book b where b.name =:name")
	Book getByName(@Param("name") String name);


}
