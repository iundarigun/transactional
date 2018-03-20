package br.com.devcave.transactional.lock.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;

    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @ManyToOne
    private User user;

//    @Version
//    private Long version;

    public Account(final BigDecimal amount, final User user) {
        this.amount = amount;
        this.user = user;
    }
}
