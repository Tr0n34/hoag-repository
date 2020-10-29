package fr.hoag.repositories;

import fr.hoag.repositories.dto.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDto, Long> {

    UserDto findByLoginAndPassword(String login, String password);

}