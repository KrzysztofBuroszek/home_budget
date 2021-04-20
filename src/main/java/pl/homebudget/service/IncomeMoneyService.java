package pl.homebudget.service;

import pl.homebudget.operationOnMoney.Expenses;
import pl.homebudget.operationOnMoney.IncomeMoney;

import java.util.List;
import java.util.Optional;

public interface IncomeMoneyService {


    List<IncomeMoney> getIncomeMoney();

    Optional<IncomeMoney> get(Long id);

    IncomeMoney add(IncomeMoney incomeMoney);

    void delete(Long id);

    void update(IncomeMoney incomeMoney);
}
