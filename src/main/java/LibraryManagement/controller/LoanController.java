package LibraryManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LibraryManagement.dto.DataTransferObjectFactory;
import LibraryManagement.dto.LoanDTO;
import LibraryManagement.exception.ResourceNotFoundException;
import LibraryManagement.model.Loan;
import LibraryManagement.repositories.LoanRepository;

@RestController
@RequestMapping(value = "loans")
public class LoanController {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private DataTransferObjectFactory dtoFactory;

	@GetMapping
	public ResponseEntity<List<LoanDTO>> getAll() {
		List<Loan> loans = loanRepository.findAll();
		List<LoanDTO> loansDto = new ArrayList<>();

		for (Loan loan : loans) {
			LoanDTO loansToDto = new LoanDTO(loan);
			loansDto.add(loansToDto);
		}

		return ResponseEntity.status(HttpStatus.OK).body(loansDto);
	}

	public ResponseEntity<LoanDTO> findById(long id) {

		Loan loan = loanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Loan not found with id = " + id));

		LoanDTO loanDto = dtoFactory.createLoanDto(loan);

		return ResponseEntity.status(HttpStatus.OK).body(loanDto);
	}
}
