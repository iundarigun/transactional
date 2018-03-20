package br.com.devcave.transactional.advanced.repository;

import br.com.devcave.transactional.advanced.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
