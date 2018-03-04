package br.com.devcave.transactional.basic.service;

import br.com.devcave.transactional.basic.domain.Bill;
import br.com.devcave.transactional.basic.domain.TypeEnum;
import br.com.devcave.transactional.basic.domain.User;
import br.com.devcave.transactional.basic.repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Double getTotalAmount(){
        log.info("M=getTotalAmount, start");
        List<User> userList = userRepository.findAll();
        log.info("M=getTotalAmount, totalUsers={}", userList.size());
        Double totalAmount = userList
                .stream()
                .mapToDouble(u -> u.getBillList()
                        .stream()
                        .mapToDouble(b -> b.getValue().doubleValue())
                        .sum())
                .sum();
        log.info("M=getTotalAmount, totalAmount={}", totalAmount);
        return totalAmount;
    }

    public void addBill(Long id, TypeEnum type, BigDecimal value) {
        User user = userRepository.getOne(id);
        Bill bill = new Bill(type, value, LocalDate.now(), user);
        user.getBillList().add(bill);
        userRepository.save(user);
    }

    public void addUsers(String... documents){
        List.of(documents).forEach(d->userRepository.save(new User(
                new Faker(new Locale("pt", "BR")).name().name(),
                d, Collections.emptyList())));
    }
}
