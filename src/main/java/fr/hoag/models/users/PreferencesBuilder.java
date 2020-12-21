package fr.hoag.models.users;

import java.util.HashMap;
import java.util.Map;

public class PreferencesBuilder {

    private Map<String, Object> preferences;

    public PreferencesBuilder() {
        this.preferences = new HashMap<>();
    }

    public PreferencesBuilder withProperties(Map<String, Object> preferences) {
        this.preferences = preferences;
        return this;
    }

    public PreferencesBuilder withPropertie(String key, Object value) {
        this.preferences.put(key, value);
        return this;
    }

    public Preferences build() {
        return new Preferences(this.preferences);
    }

}
