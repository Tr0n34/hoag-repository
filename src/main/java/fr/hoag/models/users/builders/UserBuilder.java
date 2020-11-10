package fr.hoag.models.users.builders;

import fr.hoag.models.users.Preferences;
import fr.hoag.models.users.Profile;
import fr.hoag.models.users.User;

public class UserBuilder {

    private Profile profile;
    private Preferences preferences;

    private static class UserBuilderHolder {
        static final UserBuilder builder = new UserBuilder();
    }

    private UserBuilder() {

    }

    private static UserBuilder create() {
        return UserBuilderHolder.builder;
    }

    public UserBuilder withProfile(Profile profile) {
        this.profile = profile;
        return this;
    }






    public User build() {
        return new User();
    }


}
