package fr.hoag.repositories.dto;

import fr.hoag.repositories.types.PgInet;
import fr.hoag.repositories.types.PgInetType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "users")
@Getter
@Setter(AccessLevel.PUBLIC)
@Builder(builderMethodName = "create")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
@TypeDefs(
        @TypeDef(name = "pgInet", typeClass = PgInetType.class)
)
public class UserDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1)
    private int id;
    private String login;
    private String password;
    private String email;
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Column(name = "last_login")
    private Timestamp lastLogin;
    @Column(name = "ip_addr")
    @Type(type = "pgInet")
    private PgInet ipAddress;

}
