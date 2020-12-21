package fr.hoag.repositories.dto.users;

import fr.hoag.models.users.interfaces.Adress;
import lombok.Data;

import javax.persistence.Entity;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.time.LocalDateTime;

@Entity
@Data
public class ProfileDto {

    private BufferedImage avatar;

    private LocalDateTime creationDate;
    private LocalDateTime lastConnectionDate;
    private InetAddress lastConnectionAdress;

    private String name;
    private String surname;
    private LocalDateTime birthday;
    private String email;
    private Adress adress;

}
