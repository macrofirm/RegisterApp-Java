package edu.uark.registerapp.commands.transactions;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.models.api.Transaction;
import edu.uark.registerapp.models.entities.TransactionEntity;
import edu.uark.registerapp.models.repositories.TransactionRepository;

@Service
public class StartTransactionCommand implements ResultCommandInterface<Transaction>{
    @Override
    public Transaction execute() {
        final TransactionEntity createdTransactionEntity = this.createTransactionEntity();
        
        this.apiTransaction.setId(createdTransactionEntity.getId());
        this.apiTransaction.setCreatedOn(createdTransactionEntity.getCreatedOn());

        return this.apiTransaction;
    }

    @Transactional
    private TransactionEntity createTransactionEntity() {
        return this.transactionRepository.save(
            new TransactionEntity(apiTransaction.getCashierId(), apiTransaction.getTotal()));
    }

    // Properties
    private Transaction apiTransaction;
    public Transaction getApiTransaction() {
        return this.apiTransaction;
    }
    public StartTransactionCommand setApiTransaction(final Transaction apiTransaction) {
        this.apiTransaction = apiTransaction;
        return this;
    }

    @Autowired
    private TransactionRepository transactionRepository;
}