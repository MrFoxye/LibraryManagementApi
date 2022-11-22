package LibraryManagement.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "loans")
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;
	
	@CreationTimestamp
	@Column(nullable = false)
	private OffsetDateTime reserveCreationDate;
	
	
	@Column(nullable = false)
	private OffsetDateTime reserveDueDate;
	
	
	@Column(nullable = false)
	private OffsetDateTime reserveReturnDate;
	
}
