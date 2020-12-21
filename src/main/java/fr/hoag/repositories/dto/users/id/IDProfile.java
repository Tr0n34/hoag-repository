package fr.hoag.repositories.dto.users.id;

import javax.persistence.*;
import java.util.Objects;

public class IDProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-generator")
    @SequenceGenerator(name = "seq-generator", sequenceName = "seq-profile", allocationSize = 1)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IDProfile idProfile = (IDProfile) o;
        return id.equals(idProfile.id) &&
                code.equals(idProfile.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }
    
}
