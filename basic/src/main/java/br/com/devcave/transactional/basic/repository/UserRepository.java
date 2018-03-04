package br.com.devcave.transactional.basic.repository;

import br.com.devcave.transactional.basic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
