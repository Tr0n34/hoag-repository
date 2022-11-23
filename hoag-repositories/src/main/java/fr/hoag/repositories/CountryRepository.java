package fr.hoag.repositories;

import fr.hoag.repositories.dto.CountryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<CountryDto, UUID> {

}
