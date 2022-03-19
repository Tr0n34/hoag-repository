package fr.hoag.business;

import fr.hoag.models.User;

public interface SubscriptionServices {

    public User subscribe(String username, String password, String email);

    public boolean unsubscribe(String username, String password);

}
