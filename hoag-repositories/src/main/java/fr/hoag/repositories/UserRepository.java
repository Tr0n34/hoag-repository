package fr.hoag.repositories;

import fr.hoag.repositories.dto.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDto, Integer> {

    UserDto findById(int id);

    List<UserDto> findByLogin(String login);

    List<UserDto> findDistinctByIppAddr(InetAddress inetAddress);

}
