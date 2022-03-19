package fr.hoag.repositories.types;

import lombok.*;

import java.io.Serializable;
import java.net.InetAddress;

@Builder(builderMethodName = "create")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class PgInet implements Serializable {

    private InetAddress address;

}
