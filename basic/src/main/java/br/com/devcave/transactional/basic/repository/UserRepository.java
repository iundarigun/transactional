package br.com.devcave.transactional.basic.repository;

import br.com.devcave.transactional.basic.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

}
