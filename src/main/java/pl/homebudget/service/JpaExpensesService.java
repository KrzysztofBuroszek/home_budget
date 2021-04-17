package pl.homebudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.homebudget.operationOnMoney.Expenses;
import pl.homebudget.repository.ExpensesRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaExpensesService implements ExpensesService{

    private final ExpensesRepository expensesRepository;


    public JpaExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }


    @Override
    public Expenses add(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    @Override
    public List<Expenses> getExpenses() {
        return null;
    }

    @Override
    public Optional<Expenses> get(Long id) {
        return Optional.empty();
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Expenses expenses) {

    }
}
