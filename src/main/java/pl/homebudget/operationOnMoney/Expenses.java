package pl.homebudget.operationOnMoney;

import pl.homebudget.user.Users;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Proszę uzupełnić kwotę")
    @Size(min = 1, max = 100000000)
    private String expense;

    @Size(max = 150)
    private String description;

    @Column(name = "created_on_expence")
    private LocalDate localDate;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users usersId;


    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    public Expenses() {}


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

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
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
        return " Wartość: " + expense + " " +
                " Opis: " + description  + " " +
                " Data utworzenia: " + localDate +
                "     " + usersId.getNick();
    }

}
