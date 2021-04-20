package pl.homebudget.service;

import org.springframework.stereotype.Repository;
import pl.homebudget.operationOnMoney.IncomeMoney;
import pl.homebudget.repository.IncomeMoneyRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaIncomeMoneyService implements IncomeMoneyService{

    private final IncomeMoneyRepository incomeMoneyRepository;
    private EntityManager entityManager;

    public JpaIncomeMoneyService(IncomeMoneyRepository incomeMoneyRepository) {
        this.incomeMoneyRepository = incomeMoneyRepository;
    }


    @Override
    public List<IncomeMoney> getIncomeMoney() {
        return incomeMoneyRepository.findAll();
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
