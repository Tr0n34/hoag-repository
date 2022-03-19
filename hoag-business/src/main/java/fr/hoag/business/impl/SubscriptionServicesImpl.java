package fr.hoag.business.impl;

import fr.hoag.business.SubscriptionServices;
import fr.hoag.models.User;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionServicesImpl implements SubscriptionServices {


    @Override
    public User subscribe(String username, String password, String email) {
        return null;
    }

    @Override
    public boolean unsubscribe(String username, String password) {
        return false;
    }
}
