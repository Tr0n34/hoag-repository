package fr.hoag.controllers.specifications;

import com.google.common.base.MoreObjects;

public class SearchCriteria {

    private String key;
    private String operation;
    private Object value;

    public SearchCriteria(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", key)
                .add("operation", operation)
                .add("value", value)
                .toString();
    }

}
