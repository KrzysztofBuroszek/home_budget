package userTest;

import org.junit.Test;
import pl.homebudget.controller.UserController;
import pl.homebudget.service.UsersService;
import pl.homebudget.user.Users;

import static org.junit.Assert.assertThat;



import java.math.BigDecimal;

public class UserTest {

    private UserController userController;
    private UsersService usersService;

    public UserTest() {
    }

    @Test
    void shouldCreatNewUser() {
        // given
        Users userTest = new Users();

        // when
        Users testowy = usersService.add(userTest);

        // then
    }
}
