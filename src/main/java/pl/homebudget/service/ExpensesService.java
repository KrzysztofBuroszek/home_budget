package pl.homebudget.service;

import pl.homebudget.operationOnMoney.Expenses;
import java.util.List;

public interface ExpensesService {


    List<Expenses> getExpenses();

    List<Expenses> get(Long id);

    Expenses add(Expenses expenses);

    void delete(Long id);

    void update(Expenses expenses);
}
