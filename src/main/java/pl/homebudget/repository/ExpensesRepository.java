package pl.homebudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.homebudget.operationOnMoney.Expenses;


public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

}
