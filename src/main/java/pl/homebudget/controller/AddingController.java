package pl.homebudget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.homebudget.operationOnMoney.Expenses;
import pl.homebudget.operationOnMoney.IncomeMoney;
import pl.homebudget.service.ExpensesService;
import pl.homebudget.service.IncomeMoneyService;
import pl.homebudget.user.Users;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Primary
public class AddingController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    private final ExpensesService expensesService;
    private final IncomeMoneyService incomeMoneyService;

    public AddingController(ExpensesService expensesService, IncomeMoneyService incomeMoneyService) {
        this.expensesService = expensesService;
        this.incomeMoneyService = incomeMoneyService;
    }



    @GetMapping("/add")
    public String addExpensesGet() {
        return "additionsExpenses";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addExpenses(@Valid Expenses expense, BindingResult bindingResult, Users users, Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            logger.error("result error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            logger.info((expense.getDescription()));
            logger.info((expense.getExpense()));
            return "error";
        }


        Users actual = new Users();
        actual.setId((Long) session.getAttribute("idUser"));
        logger.info(actual.getId() + "sssssssssssssssssssssssssssssssssssss");

        expense.setUsersId(actual);
        expensesService.add(expense);
        return "additionsExpenses";
    }

    @GetMapping("/addIncomeMoney")
    public String addIncomeMoneyGet() {
        return "incomeMoney";
    }


    @RequestMapping(value = "/addIncomeMoney", method = RequestMethod.POST)
    public String addIncomeMoney(@Valid IncomeMoney incomeMoney, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            logger.error("result error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            logger.info((incomeMoney.getDescription()));
            logger.info((incomeMoney.getIncomeMoney()));
            return "error";
        }
        Users actual = new Users();
        actual.setId((Long) session.getAttribute("idUser"));
        incomeMoney.setUsersIdIM(actual);
        incomeMoneyService.add(incomeMoney);
        return "incomeMoney";
    }


}
