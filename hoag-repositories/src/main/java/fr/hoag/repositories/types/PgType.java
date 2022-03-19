package fr.hoag.repositories.types;

public enum PgType {

    INET("inet");

    private String type;

    private PgType(String type) {
        this.type = type;
    }

}
