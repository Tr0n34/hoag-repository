package fr.hoag.services;

import fr.hoag.models.users.Profile;
import fr.hoag.models.users.User;
import fr.hoag.services.exceptions.BusinessServiceException;

public interface UsersServices {

    public void subscribe(User user) throws BusinessServiceException;

    public void unsubscribe(User user) throws BusinessServiceException;

    public boolean checkPassword(String password) throws BusinessServiceException;

    public boolean checkUser(User user) throws BusinessServiceException;

    public User changeProfile(User user, Profile profile) throws BusinessServiceException;

}
