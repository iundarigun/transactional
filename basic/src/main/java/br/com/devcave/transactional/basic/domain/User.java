package br.com.devcave.transactional.basic.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"document"}))
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String document;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Bill> billList = new ArrayList<>();

    public User(String name, String document, List<Bill> billList) {
        this.name = name;
        this.document = document;
        this.billList = billList;
        this.billList.forEach(b -> b.setUser(this));
    }
}
