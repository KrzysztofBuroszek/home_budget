package pl.homebudget.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import pl.homebudget.service.UsersService;
import pl.homebudget.user.Users;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@SessionAttributes("idUser")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    public final Validator validator;
    private final UsersService usersService;

    public UserController(UsersService usersService, Validator validator) {
        this.usersService = usersService;
        this.validator = validator;
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("idUser");
        session.invalidate();
        return "logOut";
    }
    @GetMapping("/login")
    public String loginGet() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid Users users, BindingResult result, HttpSession session, Model model) {


        List<Users> usersList = usersService.getUsers().stream()
                .filter(u -> u.getNick().equals(users.getNick()))
                .collect(Collectors.toList());

//        Optional<Users> idUser = usersList.stream().findFirst();

        Users usersActual = usersList.get(0);

        if (result.hasErrors()) {
            logger.info(users.getNick() + users.getPassword() + " " + "error xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return "login";
        } else if (!usersList.isEmpty()) {
            logger.info(users.getNick() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + usersActual.getId());

            session.setAttribute("idUser", usersActual.getId());
            session.removeAttribute("idUser");
            usersList.remove(0);
//            usersActual.setId(0L);


            return "dashboard";
        }
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistination() {
        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid Users user, BindingResult bindingResult) {

        List<Users> usersList = usersService.getUsers().stream()
                .filter(u -> u.getNick().equals(user.getNick()))
                .collect(Collectors.toList());
        logger.info(String.valueOf(usersList));

        if (bindingResult.hasErrors()) {
            logger.error("result error");
            return "redirect:registration";
        } else if (usersList.isEmpty()) {
            logger.info(String.valueOf(user));
            usersService.add(user);
            return "redirect: login";
        } else {
            return "redirect: login";
        }
    }

}
