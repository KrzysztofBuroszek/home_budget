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
import java.util.List;
import java.util.Set;

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



    public List<Users> getUsers(@Valid Users users) {
        try {
            List<Users>usersList = usersService.getUsers().stream()
                    .filter(u -> u.getNick().equals(users.getNick()))
                    .filter(p -> p.getPassword().equals((users.getPassword())))
                    .collect(Collectors.toList());
            return  usersList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("idUser");
        session.invalidate();
        model.addAttribute("idUser", 0);
        return "logOut";
    }
    @GetMapping("/login")
    public String loginGet() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Users users, BindingResult result, HttpSession session, Model model) {

        if (result.hasErrors()) {
            logger.info(users + users.getNick() + " " + users.getPassword() + " " + "error xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return "login";
        } else if (!getUsers(users).isEmpty()) {
            Users usersActual = getUsers(users).get(0);
            logger.info(users.getNick() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + usersActual.getId());
            session.setAttribute("idUser", usersActual.getId());
            model.addAttribute("idUser", session.getAttribute("idUser"));
            return "dashboard";
        }
        return "home";
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
