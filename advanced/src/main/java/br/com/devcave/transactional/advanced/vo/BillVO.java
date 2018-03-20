package br.com.devcave.transactional.advanced.vo;

import br.com.devcave.transactional.advanced.domain.TypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BillVO {

    private TypeEnum type;
    @JsonFormat(pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE)
    private LocalDate date;
    private BigDecimal value;
}
