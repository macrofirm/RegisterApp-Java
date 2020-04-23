package edu.uark.registerapp.commands.transactions;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.models.api.Transaction;
import edu.uark.registerapp.models.entities.TransactionEntity;
import edu.uark.registerapp.models.repositories.TransactionRepository;

@Service
public class TransactionQuery implements ResultCommandInterface<Transaction>{
    @Override
    public Transaction execute() {
        final List<TransactionEntity> transactionEntities =
            this.transactionRepository.findByCashierId(this.cashierId);
        TransactionEntity earliestTransactionEntity = transactionEntities.get(transactionEntities.size()-1);
        return new Transaction(earliestTransactionEntity);
    }

    // Properties
    private UUID cashierId;
    public UUID getCashierId() {
        return this.cashierId;
    }
    public TransactionQuery setCashierId(final UUID cashierId) {
        this.cashierId = cashierId;
        return this;
    }

    @Autowired
    private TransactionRepository transactionRepository;
}