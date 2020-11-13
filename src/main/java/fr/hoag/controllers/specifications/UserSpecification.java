package fr.hoag.controllers.specifications;

import fr.hoag.models.users.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification implements Specification<User> {

    private SearchCriteria criteria;

    public UserSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        if ( SearchCriteriaBuilder.EQUAL.equalsIgnoreCase(criteria.getOperation()) ) {
            predicate = criteriaBuilder.equal(root.get(criteria.<String>getKey()), criteria.getValue().toString());
        }
        if ( SearchCriteriaBuilder.LIKE.equalsIgnoreCase(criteria.getOperation()) ) {
            String likeString = String.join("", "%", criteria.getValue().toString(), "%");
            predicate = criteriaBuilder.like(root.get(criteria.getKey()), likeString);
        }
        return predicate;
    }


}
