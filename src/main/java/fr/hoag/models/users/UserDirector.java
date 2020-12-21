package fr.hoag.models.users;

public class UserDirector {

    UserBuilder userBuilder;
    PreferencesBuilder preferencesBuilder;
    ProfileBuilder profileBuilder;

    public UserDirector(UserBuilder userBuilder, PreferencesBuilder preferencesBuilder, ProfileBuilder profileBuilder) {
        this.userBuilder = userBuilder;
        this.preferencesBuilder = preferencesBuilder;
        this.profileBuilder = profileBuilder;
    }

    public User build() {
        return userBuilder
                .withPreferences(preferencesBuilder.build())
                .withProfile(profileBuilder.build())
                .build();
    }

}
