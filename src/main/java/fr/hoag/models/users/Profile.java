package fr.hoag.models.users;

import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.URL;
import java.time.LocalDateTime;

public class Profile {

    private URL avatarInURL;
    private BufferedImage avatarInFile;

    private LocalDateTime creationDate;
    private InetAddress lastConnectionAdress;

    private String name;
    private String surname;

}
