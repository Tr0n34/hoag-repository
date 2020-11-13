package fr.hoag.models.users;

import com.google.common.base.MoreObjects;
import fr.hoag.models.users.interfaces.Adress;

import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.URL;
import java.time.LocalDateTime;

public class Profile {

    private BufferedImage avatar;

    private LocalDateTime creationDate;
    private LocalDateTime lastConnectionDate;
    private InetAddress lastConnectionAdress;

    private String name;
    private String surname;
    private LocalDateTime birthday;
    private String email;
    private Adress adress;

    public Profile(BufferedImage avatar,
                   LocalDateTime creationDate, LocalDateTime lastConnectionDate,
                   InetAddress lastConnectionAdress,
                   String name, String surname, LocalDateTime birthday, String email,
                   Adress adress) {
        this.avatar = avatar;
        this.creationDate = creationDate;
        this.lastConnectionDate = lastConnectionDate;
        this.lastConnectionAdress = lastConnectionAdress;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.adress = adress;
    }

    public BufferedImage getAvatar() {
        return avatar;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastConnectionDate() {
        return lastConnectionDate;
    }

    public InetAddress getLastConnectionAdress() {
        return lastConnectionAdress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public Adress getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("avatar", avatar)
                .add("creationDate", creationDate)
                .add("lastConnectionDate", lastConnectionDate)
                .add("lastConnectionAdress", lastConnectionAdress)
                .add("name", name)
                .add("surname", surname)
                .add("birthday", birthday)
                .add("email", email)
                .add("adress", adress)
                .toString();
    }

}
