package fr.hoag.services;

import fr.hoag.models.referentials.FrenchAdress;

public interface FrenchAdressServices {

    public FrenchAdress search(String q, String type, String codePostal, String codeInsee, int autoComplete, int limit);

}
