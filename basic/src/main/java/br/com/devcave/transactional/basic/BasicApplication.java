package br.com.devcave.transactional.basic;

import br.com.devcave.transactional.basic.domain.Bill;
import br.com.devcave.transactional.basic.domain.TypeEnum;
import br.com.devcave.transactional.basic.domain.User;
import br.com.devcave.transactional.basic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @Autowired
    public void create(UserRepository userRepository) {
        User userOne = new User("User One", LocalDate.of(2000, 10, 3),
                List.of(new Bill(TypeEnum.ENERGY, BigDecimal.valueOf(20.10), LocalDate.of(2018, 1, 1), null)));
        userRepository.save(userOne);

//                        List.of(roleRepository.findByName("USER"))),
//                new User("User Two", LocalDate.of(1998,7,10),
//                        List.of(roleRepository.findByName("MANAGER"))),
//                new User("User three", LocalDate.of(1993,2,28),
//                        List.of(roleRepository.findByName("USER"),roleRepository.findByName("MANAGER"))),
//                new User("User Four", LocalDate.of(1980,8,7),
//                        List.of(roleRepository.findByName("USER"), roleRepository.findByName("MANAGER"),roleRepository.findByName("ADMIN"))))
//            .forEach(userRepository::save);
    }
}
