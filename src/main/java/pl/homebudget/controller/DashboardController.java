package pl.homebudget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.homebudget.operationOnMoney.Expenses;
import pl.homebudget.operationOnMoney.IncomeMoney;
import pl.homebudget.service.ExpensesService;
import pl.homebudget.service.IncomeMoneyService;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    private final ExpensesService expensesService;
    private final IncomeMoneyService incomeMoneyService;

    public DashboardController(ExpensesService expensesService, IncomeMoneyService incomeMoneyService) {
        this.expensesService = expensesService;
        this.incomeMoneyService = incomeMoneyService;
    }


    @GetMapping("/dashboard")
    public String dashboardGetIncomeMoney(@ModelAttribute("IncomeMoney") IncomeMoney incomeMoney, Model model, HttpSession session) {


        List<IncomeMoney> all = incomeMoneyService.getIncomeMoney().stream()
                .filter(u -> u.getUsersIdIM().getId().equals(session.getAttribute("idUser")))
                .collect(Collectors.toList());
        model.addAttribute("incomeMoney", all);
        logger.info(session.getAttribute("idUser") + " dadadadadadadadadaaaa");
        model.addAttribute("idUser", session.getAttribute("idUser"));
        model.addAttribute("nick", session.getAttribute("nick"));
        return "dashboard";
    }

    @ModelAttribute("expenses")
    public List<Expenses> dashboardGetExpenses(HttpSession session) {
        List<Expenses> all = expensesService.getExpenses().stream()
                .filter(u -> u.getUsersId().getId().equals(session.getAttribute("idUser")))
                .collect(Collectors.toList());
        logger.info(all + " dfbfbsdknfsakcdoiasjfduakscbasc");
        return all;
    }

    @ModelAttribute("expensesSum")
    public String dashboardGetExpansesSum() {
        return null;
    }
}
