package fr.hoag.services;

import fr.hoag.models.users.Profile;
import fr.hoag.models.users.User;
import fr.hoag.services.exceptions.BusinessServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UsersServices {

    public User subscribe(User user) throws BusinessServiceException;

    public boolean unsubscribe(User user) throws BusinessServiceException;

    public boolean checkPassword(String password) throws BusinessServiceException;

    public boolean checkUser(User user) throws BusinessServiceException;

    public User changeProfile(User user, Profile profile) throws BusinessServiceException;

    public User createUser(User user) throws BusinessServiceException;

    public User updateUser(User oldUser, User newUser) throws BusinessServiceException;

    public boolean deleteUser(User user) throws BusinessServiceException;

    public User findById(Long id) throws BusinessServiceException;

    public Page<User> findUser(Specification<User> userSpecification, Pageable pageable) throws BusinessServiceException;

}
