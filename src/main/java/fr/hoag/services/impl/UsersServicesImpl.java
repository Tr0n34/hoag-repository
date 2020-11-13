package fr.hoag.services.impl;

import fr.hoag.models.users.Profile;
import fr.hoag.models.users.User;
import fr.hoag.validators.UserValidator;
import fr.hoag.services.UsersServices;
import fr.hoag.services.exceptions.BusinessServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import fr.hoag.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServicesImpl implements UsersServices {

    @Autowired
    UserRepository userRepository;

    UserValidator userValidator;

    @Override
    public User subscribe(User user) throws BusinessServiceException {
        return null;
    }

    @Override
    public boolean unsubscribe(User user) throws BusinessServiceException {
        return true;
    }

    @Override
    public boolean checkPassword(String password) throws BusinessServiceException {
        return false;
    }

    @Override
    public boolean checkUser(User user) throws BusinessServiceException {
        return false;
    }

    @Override
    public User changeProfile(User user, Profile profile) throws BusinessServiceException {
        return null;
    }

    @Override
    public User createUser(User user) throws BusinessServiceException {
        return null;
    }

    @Override
    public User updateUser(User oldUser, User newUser) throws BusinessServiceException {
        return null;
    }

    @Override
    public boolean deleteUser(User user) throws BusinessServiceException {
        return false;
    }

    @Override
    public User findById(Long id) throws BusinessServiceException {
        return null;
    }

    @Override
    public Page<User> findUser(Specification<User> userSpecification, Pageable pageable) throws BusinessServiceException {
        return userRepository.findAll(userSpecification, pageable);
    }
}
