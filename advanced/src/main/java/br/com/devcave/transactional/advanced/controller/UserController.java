package br.com.devcave.transactional.advanced.controller;

import br.com.devcave.transactional.advanced.domain.TypeEnum;
import br.com.devcave.transactional.advanced.domain.User;
import br.com.devcave.transactional.advanced.exception.TransactionalException;
import br.com.devcave.transactional.advanced.service.UserService;
import br.com.devcave.transactional.advanced.vo.BillVO;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/total-amount")
    public Double getTotalAmount() {
        return userService.getTotalAmount();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        log.info("M=getUser, id={}", id);
        final User user = userService.getUser(id);
        log.info("M=getUser, usuario recuperado");
        return user;
    }

    @PostMapping("/{id}/{type}/{value}")
    public void addBill(@PathVariable Long id, @PathVariable TypeEnum type, BigDecimal value) {
        userService.addBill(id, type, value);
    }

    @PostMapping("/")
    public void createUser(@RequestBody String... documents) {
        userService.addUsers(documents);
    }

    @PostMapping("/{id}/add1BillsCheckedException")
    public void addBillsCheckedException(@PathVariable Long id, @RequestBody List<BillVO> billList)
            throws TransactionalException {
        userService.addBillsCheckedException(id, billList);
    }

    @PostMapping("/{id}/add2BillsCheckedExceptionWithRollback")
    public void addBillsCheckedExceptionWithRollback(@PathVariable Long id, @RequestBody List<BillVO> billList) throws
            TransactionalException {
        userService.addBillsCheckedExceptionWithRollback(id, billList);
    }

    @PostMapping("/{id}/add3BillsUncheckedException")
    public void addBillsUncheckedException(@PathVariable Long id, @RequestBody List<BillVO> billList) {
        userService.addBillsUncheckedException(id, billList);
    }

    @PostMapping("/{id}/add4BillsCatchingPrivateUncheckedException")
    public void addBillsCatchingPrivateUncheckedException(@PathVariable Long id, @RequestBody List<BillVO> billList) {
        userService.addBillsCatchingPrivateUncheckedException(id, billList);
    }

    @PostMapping("/{id}/add5BillsCatchingProxyUncheckedException")
    public void addBillsCatchingProxyUncheckedException(@PathVariable Long id, @RequestBody List<BillVO> billList) {
        userService.addBillsCatchingProxyUncheckedException(id, billList);
    }

    @PostMapping("/{id}/add6BillsCatchingProxyUncheckedExceptionWithoutRollback")
    public void addBillsCatchingProxyUncheckedExceptionWithoutRollback(@PathVariable Long id, @RequestBody List<BillVO> billList) {
        userService.addBillsCatchingProxyUncheckedExceptionWithoutRollback(id, billList);
    }

    @PostMapping("/{id}/add7BillsNewTransactionInThisClass")
    public void addBillsNewTransactionInThisClass(@PathVariable Long id, @RequestBody List<BillVO> billList) {
        userService.addBillsNewTransactionInThisClass(id, billList);
    }

    @PostMapping("/{id}/add8BillsNewTransactionByProxy")
    public void addBillsNewTransactionByProxy(@PathVariable Long id, @RequestBody List<BillVO> billList) {
        userService.addBillsNewTransactionByProxy(id, billList);
    }
}
