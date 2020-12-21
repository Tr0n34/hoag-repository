package fr.hoag.models.users;

import fr.hoag.models.users.interfaces.Adress;

import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.time.LocalDateTime;

public class ProfileBuilder {

    private BufferedImage avatar;
    private LocalDateTime creationDate;
    private LocalDateTime lastConnectionDate;
    private InetAddress lastConnectionAdress;
    private String name;
    private String surname;
    private LocalDateTime birthday;
    private String email;
    private Adress adress;

    public ProfileBuilder() {

    }

    public ProfileBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProfileBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ProfileBuilder withBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    public ProfileBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public ProfileBuilder withCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public ProfileBuilder withLastConnectionDate(LocalDateTime lastConnectionDate) {
        this.lastConnectionDate = lastConnectionDate;
        return this;
    }

    public ProfileBuilder withLastConnectionAdress(InetAddress lastConnectionAdress) {
        this.lastConnectionAdress = lastConnectionAdress;
        return this;
    }

    public ProfileBuilder withAdress(Adress adress) {
        this.adress = adress;
        return this;
    }

    public ProfileBuilder withAvatar(BufferedImage avatar) {
        this.avatar = avatar;
        return this;
    }

    public Profile build() {
        return new Profile(avatar, creationDate, lastConnectionDate, lastConnectionAdress,
                name, surname, birthday, email, adress);
    }

}
