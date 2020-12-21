package fr.hoag.models.users;

import com.google.common.base.MoreObjects;

import java.util.HashMap;
import java.util.Map;

public class Preferences {

    private Map<String, Object> properties;

    public Preferences() {
        this.properties = new HashMap<>();
    }

    public Preferences(Map<String, Object> preferences) {
        this.properties = preferences;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void put(String key, Object value) {
        this.properties.put(key, value);
    }

    public void remove(String key) {
        this.properties.remove(key);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("properties", properties)
                .toString();
    }

}
