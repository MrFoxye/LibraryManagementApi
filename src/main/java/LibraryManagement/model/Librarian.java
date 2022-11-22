package LibraryManagement.model;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(name = "librarians")
@NoArgsConstructor
public class Librarian {

	@Id
	@Column(name = "id")
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long id;
	
	@NonNull
	@Column(nullable = false, name = "name")
	private String name;
	
	@NonNull
	@Embedded
	private Adress adress;
	
	
}
