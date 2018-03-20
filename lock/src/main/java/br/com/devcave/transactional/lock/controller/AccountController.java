package br.com.devcave.transactional.lock.controller;

import br.com.devcave.transactional.lock.service.AccountService;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping(value = "/user/{userId}/add")
    public void addValue(@PathVariable Long userId, @RequestParam("value") BigDecimal value){
        accountService.addValue(userId, value);
    }

    @PutMapping(value = "/user/{userId}/addSlow")
    public void addSlowValue(@PathVariable Long userId, @RequestParam("value") BigDecimal value)
            throws InterruptedException {
        accountService.addSlowValue(userId, value);
    }
}
