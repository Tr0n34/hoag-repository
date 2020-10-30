package fr.hoag.models.users;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class User {

    private String login;
    private String password;
    private String email;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(login);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("login", login)
                .add("password", password)
                .add("email", email)
                .toString();
    }

}
