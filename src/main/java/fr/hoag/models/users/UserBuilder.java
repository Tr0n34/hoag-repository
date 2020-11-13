package fr.hoag.models.users;

public class UserBuilder {

    private String username;
    private String password;

    private Profile profile;
    private Preferences preferences;

    private static class UserBuilderHolder {
        static final UserBuilder builder = new UserBuilder();
    }

    private UserBuilder() {

    }

    public static UserBuilder create() {
        return UserBuilderHolder.builder;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withProfile(Profile profile) {
        this.profile = profile;
        return this;
    }

    public UserBuilder withPreferences(Preferences preferences) {
        this.preferences = preferences;
        return this;
    }

    public User build() {
        return new User(username, password, profile, preferences);
    }

}
