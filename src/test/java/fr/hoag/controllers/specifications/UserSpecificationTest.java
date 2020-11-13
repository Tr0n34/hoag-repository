package fr.hoag.controllers.specifications;

import fr.hoag.models.users.User;
import fr.hoag.services.UsersServices;
import fr.hoag.services.exceptions.BusinessServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
public class UserSpecificationTest {

    @Autowired
    UsersServices usersServices;

    @Test
    public void should_spec() throws BusinessServiceException {
        SearchCriteria criteria = new SearchCriteriaBuilder().key("login").operation("=").value("devtest").build();
        UserSpecification userSpecification = new UserSpecification(criteria);
        usersServices.findUser(userSpecification, PageRequest.of(1, 10));
    }

}
