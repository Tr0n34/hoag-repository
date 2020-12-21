package fr.hoag.models.users;

public class Role {

    private String name;
    private String label;
    private String description;

    public Role(String name, String label, String description) {
        this.label = label;
        this.name = name;
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
