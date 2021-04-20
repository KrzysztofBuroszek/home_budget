package pl.homebudget.service;

import pl.homebudget.operationOnMoney.Expenses;
import java.util.List;
import java.util.Optional;

public interface ExpensesService {


    List<Expenses> getExpenses();

    Optional<Expenses> get(Long id);

    Expenses add(Expenses expenses);

    void delete(Long id);

    void update(Expenses expenses);
}
