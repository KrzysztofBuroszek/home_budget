package pl.homebudget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.homebudget.operationOnMoney.Expenses;
import pl.homebudget.operationOnMoney.IncomeMoney;
import pl.homebudget.service.ExpensesService;
import pl.homebudget.service.IncomeMoneyService;

import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    private final ExpensesService expensesService;
    private final IncomeMoneyService incomeMoneyService;

    public DashboardController(ExpensesService expensesService, IncomeMoneyService incomeMoneyService) {
        this.expensesService = expensesService;
        this.incomeMoneyService = incomeMoneyService;
    }


//    @GetMapping("/dashboard")
//    public String dashboard(Model model){
//        List<IncomeMoney> all = incomeMoneyService.getIncomeMoney();
//        List<Expenses> allExpenses = expensesService.getExpenses();
//
//        logger.info((all) + "XxxxxXXxxXXXxxxxxxXXXxxxxXXXxxXXX");
//        logger.info((allExpenses) + "yyyyyyyyyyyyyyyyyyyyyyyyyyyy");
//        model.addAttribute("incomeMoney", all);
//        model.addAttribute("expenses", allExpenses);
//        return "dashboard";
//    }

    @GetMapping("/dashboard")
    public String dashboardGetIncomeMoney(@ModelAttribute("IncomeMoney") IncomeMoney incomeMoney, Model model) {
        List<IncomeMoney> all = incomeMoneyService.getIncomeMoney();
        model.addAttribute("incomeMoney", all);
        return "dashboard";
    }

    @ModelAttribute("expenses")
    public List<Expenses> dashboardGetExpenses() {
         List<Expenses> all = expensesService.getExpenses();
        return all;
    }

    @ModelAttribute("expensesSum")
    public String dashboardGetExpansesSum(){
        return null;
    }





}
