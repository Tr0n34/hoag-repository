package fr.hoag.repositories.dto.users;

import fr.hoag.repositories.dto.users.id.IDUser;
import fr.hoag.repositories.encryptions.HashDataConverter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "User")
@Table(name = "users", schema = "ft000")
public class UserDto implements Serializable {


    private IDUser key;

    @Column(unique = true)
    private String username;

    @Convert(converter = HashDataConverter.class)
    private String password;




}
