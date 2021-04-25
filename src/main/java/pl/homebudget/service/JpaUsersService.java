package pl.homebudget.service;

import org.springframework.stereotype.Repository;
import pl.homebudget.repository.UsersRepository;
import pl.homebudget.user.Users;
import java.util.List;
import java.util.Optional;


@Repository
public class JpaUsersService implements UsersService{

   private final UsersRepository usersRepository;

    public JpaUsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public Users add(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Users users) {

    }

    @Override
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> get(Long id) {
        return Optional.empty();
    }

    @Override
    public String getNick(Users users) {
        Optional<Users> usersOptional = Optional.ofNullable(users);
        return usersOptional.map(Users::getNick).orElse("getNick Error");
    }


}
