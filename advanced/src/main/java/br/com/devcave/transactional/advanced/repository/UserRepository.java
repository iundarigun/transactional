package br.com.devcave.transactional.advanced.repository;

import br.com.devcave.transactional.advanced.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
