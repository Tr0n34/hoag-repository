package fr.hoag.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("integration")
public class FrenchAdressServicesTestIntegration {

    @Autowired
    FrenchAdressServices adressServices;

    @Test
    void should_find_adress() {
        adressServices.search("26 rue sanche de pomiers", "", "33000", "", 1, 0);
    }
}
