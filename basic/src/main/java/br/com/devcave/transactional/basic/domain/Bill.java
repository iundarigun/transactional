package br.com.devcave.transactional.basic.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue
    private Long id;

    private TypeEnum type;

    private BigDecimal value;

    private LocalDate referenceDate;

    @ManyToOne
    private User user;

    public Bill(TypeEnum type, BigDecimal value, LocalDate referenceDate, User user) {
        this.type = type;
        this.value = value;
        this.referenceDate = referenceDate;
        this.user = user;
    }
}
