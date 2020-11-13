package fr.hoag.repositories.dto;

import com.google.common.base.Objects;
import fr.hoag.repositories.encryptions.HashDataConverter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "User")
@Table(name = "users", schema = "ft000")
public class UserDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-generator")
    @SequenceGenerator(name = "seq-generator", sequenceName = "ft000.seq-user", allocationSize=1)
    private Long id;
    @Column(unique = true)
    private String login;
    @Convert(converter = HashDataConverter.class)
    private String password;
    private String email;

    protected UserDto() {

    }

    public UserDto(Long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public UserDto(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("login", login)
                .add("password", password)
                .add("email", email)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto user = (UserDto) o;
        return Objects.equal(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, login, password, email);
    }

}
