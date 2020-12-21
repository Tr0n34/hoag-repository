package fr.hoag.controllers.specifications;

public class SearchCriteriaBuilder {

    public static final String EQUAL = "=";
    public static final String LIKE = ":";
    public static final String LOWER_THAN = "<";
    public static final String UPPER_THAN = ">";

    private String key;
    private String operation;
    private Object value;

    public SearchCriteriaBuilder() {

    }

    public SearchCriteriaBuilder key(String key) {
        this.key = key;
        return this;
    }

    public SearchCriteriaBuilder operation(String operation) {
        this.operation = operation;
        return this;
    }

    public SearchCriteriaBuilder value(Object value) {
        this.value = value;
        return this;
    }

    public SearchCriteria build() {
        return new SearchCriteria(key, operation, value);
    }

}
