package fr.hoag.tests.repositories;

import fr.hoag.repositories.CountryRepository;
import fr.hoag.repositories.dto.CountryDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("staging")
public class CountryRepositoryTi {

    @Autowired
    ApplicationContext context;

    @Autowired
    CountryRepository countryRepository;

    @AfterEach
    public void afterEach() {
        countryRepository.deleteAll();
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Rollback(false)
    public void should_save_country() throws Exception {
        CountryDto country = CountryDto.create()
                .countryCode("AF")
                .alpha2("01")
                .alpha3("002")
                .region("test")
                .name("testNomPays")
                .build();
        UUID savedUUID = countryRepository.save(country).getId();
        CountryDto savedCountry = countryRepository.getById(savedUUID);
        assertThat(savedCountry).isNotNull();
        assertThat(country).isEqualTo(savedCountry);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    @Rollback(false)
    public void should_throw_not_unique_country_code_exception() {
        assertThatThrownBy(
                () -> {
                    CountryDto country1 = CountryDto.create()
                            .countryCode("AF")
                            .alpha2("01")
                            .alpha3("002")
                            .region("test1")
                            .name("testNomPays1")
                            .build();
                    CountryDto country2 = CountryDto.create()
                            .countryCode("AF")
                            .alpha2("03")
                            .alpha3("003")
                            .region("test2")
                            .name("testNomPays2")
                            .build();
                    countryRepository.save(country1);
                    countryRepository.save(country2);
                }
        ).isInstanceOf(PSQLException.class).hasMessageContaining("violate");
    }

}
