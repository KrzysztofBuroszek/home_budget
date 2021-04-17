package pl.homebudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.homebudget.user.Users;



public interface UsersRepository extends JpaRepository<Users, Long> {


}
