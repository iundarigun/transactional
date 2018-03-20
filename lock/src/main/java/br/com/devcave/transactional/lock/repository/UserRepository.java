package br.com.devcave.transactional.lock.repository;

import br.com.devcave.transactional.lock.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
