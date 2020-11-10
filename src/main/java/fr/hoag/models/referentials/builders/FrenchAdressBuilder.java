package fr.hoag.models.referentials.builders;

import fr.hoag.models.referentials.FrenchAdress;

public class FrenchAdressBuilder {

    private FrenchAdressBuilder() {

    }

    public static FrenchAdressBuilder newBuilder() {
        return new FrenchAdressBuilder();
    }

    public FrenchAdress build() {
        return new FrenchAdress();
    }

}
