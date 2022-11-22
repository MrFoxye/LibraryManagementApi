package LibraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import LibraryManagement.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

}
