package fr.hoag.repositories.dto;

import lombok.*;

import javax.persistence.*;
import java.net.InetAddress;
import java.sql.Timestamp;

@Entity
@Getter
@Builder(builderMethodName = "create")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 50)
    private int id;
    private String login;
    private String password;
    private String email;
    private Timestamp createdOn;
    private Timestamp lastLogin;
    private InetAddress ippAddr;

}
