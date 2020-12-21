package fr.hoag.controllers;

import fr.hoag.models.users.User;
import fr.hoag.services.UsersServices;
import fr.hoag.services.exceptions.BusinessServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UsersServices usersServices;

    @RequestMapping("/subscribe")
    public boolean subscribe(User user) {
        return true;
    }

    @RequestMapping("/unsubscribe")
    public boolean unsubscribe(User user) throws BusinessServiceException {
        return usersServices.unsubscribe(user);
    }




}
