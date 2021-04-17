package pl.homebudget.service;

import org.springframework.stereotype.Repository;
import pl.homebudget.operationOnMoney.IncomeMoney;
import pl.homebudget.repository.IncomeMoneyRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaIncomeMoneyService implements IncomeMoneyService{

    private final IncomeMoneyRepository incomeMoneyRepository;

    public JpaIncomeMoneyService(IncomeMoneyRepository incomeMoneyRepository) {
        this.incomeMoneyRepository = incomeMoneyRepository;
    }


    @Override
    public List<IncomeMoney> getExpenses() {
        return null;
    }

    @Override
    public Optional<IncomeMoney> get(Long id) {
        return Optional.empty();
    }

    @Override
    public IncomeMoney add(IncomeMoney incomeMoney) {
        return incomeMoneyRepository.save(incomeMoney);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(IncomeMoney incomeMoney) {

    }
}
