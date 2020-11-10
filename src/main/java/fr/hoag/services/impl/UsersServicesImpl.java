package fr.hoag.services.impl;

import fr.hoag.models.users.Profile;
import fr.hoag.models.users.User;
import fr.hoag.validators.UserValidator;
import fr.hoag.services.UsersServices;
import fr.hoag.services.exceptions.BusinessServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import fr.hoag.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersServicesImpl implements UsersServices {

    @Autowired
    UserRepository userRepository;

    UserValidator userValidator;

    @Override
    public void subscribe(User user) throws BusinessServiceException {

    }

    @Override
    public void unsubscribe(User user) throws BusinessServiceException {

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
}
