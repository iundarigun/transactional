package br.com.devcave.transactional.transaction.repository;

import br.com.devcave.transactional.transaction.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
