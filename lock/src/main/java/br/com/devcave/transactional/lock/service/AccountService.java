package br.com.devcave.transactional.lock.service;

import br.com.devcave.transactional.lock.domain.Account;
import br.com.devcave.transactional.lock.repository.AccountRepository;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void addValue(final Long userId, final BigDecimal value) {
        log.info("M=addValue, inicio");
        final Account account = accountRepository.findByUser_id(userId);
        account.setAmount(account.getAmount().add(value));
    }

    @Transactional
    public void addSlowValue(final Long userId, final BigDecimal value) throws InterruptedException {
        log.info("M=addSlowValue, inicio");
        final Account account = accountRepository.findByUser_id(userId);
        account.setAmount(account.getAmount().add(value));
        Thread.sleep(10_000);
    }

}
