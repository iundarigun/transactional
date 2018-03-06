package br.com.devcave.transactional.transaction.service;

import br.com.devcave.transactional.transaction.domain.Bill;
import br.com.devcave.transactional.transaction.domain.TypeEnum;
import br.com.devcave.transactional.transaction.domain.User;
import br.com.devcave.transactional.transaction.repository.UserRepository;
import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Double getTotalAmount() {
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

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        log.info("M=getUser, id={}", id);
        User user = userRepository.getOne(id);
        user.setName("Sr(a). " + user.getName());
        return user;
    }

    @Transactional
    public void addBill(Long id, TypeEnum type, BigDecimal value) {
        User user = userRepository.getOne(id);
        Bill bill = new Bill(type, value, LocalDate.now(), user);
        user.getBillList().add(bill);
    }

    @Transactional
    public void addUsers(String... documents) {
        List.of(documents).forEach(d -> userRepository.save(new User(
                new Faker(new Locale("pt", "BR")).name().name(),
                d, Collections.emptyList())));
    }
}
