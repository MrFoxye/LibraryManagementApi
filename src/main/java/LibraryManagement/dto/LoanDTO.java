package LibraryManagement.dto;

import java.time.OffsetDateTime;

import LibraryManagement.model.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
	
	private BookDTO book;
	
	private StudentDTO student;	
	
	private OffsetDateTime reserveCreationDate;

	private OffsetDateTime reserveDueDate;
	
	private OffsetDateTime reserveReturnDate;
	
	public LoanDTO(Loan loan) {
		this.reserveCreationDate = loan.getReserveCreationDate();
		this.reserveDueDate = loan.getReserveDueDate();
		this.reserveReturnDate = loan.getReserveReturnDate();
	}
}
