package pl.homebudget.user;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sequence / auto
    private Long id;

    @Size(min = 1, max = 100, message = "Proszę uzupełnić imię")
    private String name;

    @NotEmpty(message = "Proszę uzupełnić nick")
    @Size(min = 1, max = 100)
    private String nick;

    private String mail;

    private String password;

    public Users(){};


    public Users(Long id, String name, String nick, String mail, String password) {
        this.id = id;
        this.name = name;
        this.nick = nick;
        this.mail = mail;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
