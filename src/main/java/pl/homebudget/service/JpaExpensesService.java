package pl.homebudget.service;

import org.springframework.stereotype.Repository;
import pl.homebudget.operationOnMoney.Expenses;
import pl.homebudget.repository.ExpensesRepository;

import java.util.Collections;
import java.util.List;

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
        return expensesRepository.findAll();
    }

    @Override
    public List<Expenses> get(Long id) {
        return expensesRepository.findAllById(Collections.singleton(id));
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Expenses expenses) {

    }
}
