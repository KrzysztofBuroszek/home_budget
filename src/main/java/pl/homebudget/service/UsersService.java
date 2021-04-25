package pl.homebudget.service;
import pl.homebudget.user.Users;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<Users> getUsers();

    Optional<Users> get(Long id);

    String getNick(Users usersNick);

    Users add(Users users);

    void delete(Long id);

    void update(Users users);
}
