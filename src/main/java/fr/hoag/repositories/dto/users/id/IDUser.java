package fr.hoag.repositories.dto.users.id;


import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

public class IDUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-generator")
    @SequenceGenerator(name = "seq-generator", sequenceName = "ft000.seq-user", allocationSize = 1)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IDUser idUser = (IDUser) o;
        return Objects.equal(id, idUser.id) &&
                Objects.equal(code, idUser.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, code);
    }

}
