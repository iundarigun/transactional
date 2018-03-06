package br.com.devcave.transactional.basic.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
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
