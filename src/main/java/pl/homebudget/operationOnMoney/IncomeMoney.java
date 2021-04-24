package pl.homebudget.operationOnMoney;

import pl.homebudget.user.Users;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "incomeMoney")
public class IncomeMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;


    @NotEmpty(message = "Proszę uzupełnić kwotę")
    @Size(min = 1, max = 100000000)
    private String incomeMoney;

    @Size(max = 150)
    private String description;


    @Column(name = "created_on_incomeMoney")
    private LocalDate localDate;


    @ManyToOne
    @JoinColumn(name = "users_id_IM")
    private Users usersIdIM;


    public IncomeMoney() {
    }

    public IncomeMoney(Long id, @NotEmpty(message = "Proszę uzupełnić kwotę") @Size(min = 1, max = 100000000) String incomeMoney, @Size(max = 150) String description, LocalDate localDate) {
        this.id = id;
        this.incomeMoney = incomeMoney;
        this.description = description;
        this.localDate = localDate;
    }

    public Users getUsersIdIM() {
        return usersIdIM;
    }

    public void setUsersIdIM(Users usersIdIM) {
        this.usersIdIM = usersIdIM;
    }

    @PrePersist
    public void prePersist() {
        localDate = LocalDate.now();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(String incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return ", Wartość:" + incomeMoney + " " +
                ", Opis:" + description + " " +
                ", Data utworzenia:" + localDate;
    }
}

