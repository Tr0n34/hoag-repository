package fr.hoag.repositories;

import fr.hoag.repositories.dto.CountryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<CountryDto, UUID> {

}
