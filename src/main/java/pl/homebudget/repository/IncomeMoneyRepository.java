package pl.homebudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.homebudget.operationOnMoney.IncomeMoney;

public interface IncomeMoneyRepository extends JpaRepository<IncomeMoney, Long> {
}
