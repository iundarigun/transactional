package br.com.devcave.transactional.basic.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDate born;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Bill> billList = new ArrayList<>();

    public User(String name, LocalDate born, List<Bill> billList) {
        this.name = name;
        this.born = born;
        this.billList = billList;
        this.billList.forEach(b -> b.setUser(this));
    }
}
