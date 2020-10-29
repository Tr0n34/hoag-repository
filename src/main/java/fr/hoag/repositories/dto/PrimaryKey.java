package fr.hoag.repositories.dto;


import com.google.common.base.Objects;
import fr.hoag.repositories.encryptions.EncryptionConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.io.Serializable;

public class PrimaryKey implements Serializable {

    @Column(name = "id")
    @Convert(converter = EncryptionConverter.class)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimaryKey that = (PrimaryKey) o;
        return Objects.equal(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
