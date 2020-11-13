package fr.hoag.repositories;

import fr.hoag.repositories.dto.UserDto;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDto, Long>, JpaSpecificationExecutor {

    UserDto findByLoginAndPassword(String login, String password);

    List<UserDto> findByLogin(String login);

}