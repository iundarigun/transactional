package br.com.devcave.transactional.advanced.service;

import br.com.devcave.transactional.advanced.vo.BillVO;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ValidationService {

    @Transactional
    public void validateBillWithUncheckedException(BillVO bill) {
        if (bill.getDate().isAfter(LocalDate.now())) {
            throw new RuntimeException();
        }
    }
}
