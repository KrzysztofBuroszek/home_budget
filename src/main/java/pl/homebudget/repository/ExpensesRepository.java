package pl.homebudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.homebudget.operationOnMoney.Expenses;

import java.util.List;
import java.util.Optional;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
//    Optional<Expenses> findAllById(Long id);
//    List<Expenses> findAllById(Long id);
}
