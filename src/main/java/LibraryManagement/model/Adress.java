package LibraryManagement.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Embeddable
@NoArgsConstructor
public class Adress {

	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false, name = "street")
	private String Street;
	
	@Column(nullable = false)
	private String houseNumber;
	
	@Column(nullable = false, name = "adress_postalcode")
	private String postalCode;
	
	@Column(nullable = false, name = "district")
	private String district;
	
	
}
