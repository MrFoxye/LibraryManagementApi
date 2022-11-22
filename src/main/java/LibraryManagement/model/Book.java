package LibraryManagement.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	@Column(nullable = false)
	@EqualsAndHashCode.Include
	private String name;
	
	@Column(nullable = false)
	private String cover;
	
	@NonNull
	@Column(nullable = false)
	private Double price;
	
	
	@Column(nullable = false)
	private String genre;
	
	@Column(nullable = false)
	private int pages;
	
	@Lob @Basic(fetch=FetchType.LAZY)
	private String description;
	
	@NonNull
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Author author;
		
	
	
	
	
	

}
