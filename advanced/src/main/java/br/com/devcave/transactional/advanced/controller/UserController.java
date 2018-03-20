package br.com.devcave.transactional.advanced.controller;

import br.com.devcave.transactional.advanced.domain.TypeEnum;
import br.com.devcave.transactional.advanced.domain.User;
import br.com.devcave.transactional.advanced.service.UserService;
import br.com.devcave.transactional.advanced.vo.BillVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/total-amount")
    public Double getTotalAmount(){
        return userService.getTotalAmount();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        log.info("M=getUser, id={}", id);
        final User user = userService.getUser(id);
        log.info("M=getUser, usuario recuperado");
        return user;
    }

    @PostMapping("/{id}/{type}/{value}")
    public void addBill(@PathVariable Long id, @PathVariable TypeEnum type, BigDecimal value){
        userService.addBill(id,type,value);
    }

    @PostMapping("/")
    public void createUser(@RequestBody String... documents){
        userService.addUsers(documents);
    }


    @PostMapping("/{id}/addBillsCheckedException")
    public void addBillsCheckedException(@PathVariable Long id, @RequestBody List<BillVO> billList) throws Exception {
        userService.addBillsCheckedException(id,billList);
    }

    @PostMapping("/{id}/addBillsCheckedExceptionWithRollback")
    public void addBillsCheckedExceptionWithRollback(@PathVariable Long id, @RequestBody List<BillVO> billList) throws Exception {
        userService.addBillsCheckedExceptionWithRollback(id,billList);
    }

    @PostMapping("/{id}/addBillsUncheckedException")
    public void addBillsUncheckedException(@PathVariable Long id, @RequestBody List<BillVO> billList) throws Exception {
        userService.addBillsUncheckedException(id,billList);
    }
}
