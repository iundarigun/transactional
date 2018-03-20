package br.com.devcave.transactional.lock.repository;

import br.com.devcave.transactional.lock.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUser_id(Long userId);

}
