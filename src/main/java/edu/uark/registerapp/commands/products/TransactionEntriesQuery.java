package edu.uark.registerapp.commands.products;

import java.util.UUID;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;

import edu.uark.registerapp.models.api.TransactionEntry;
import edu.uark.registerapp.models.entities.TransactionEntryEntity;
import edu.uark.registerapp.models.repositories.TransactionEntryRepository;

@Service
public class TransactionEntriesQuery implements ResultCommandInterface<List<TransactionEntry>>{
    @Override
    public List<TransactionEntry> execute() {
        final LinkedList<TransactionEntry> transactionEntries = new LinkedList<TransactionEntry>();

        for (final TransactionEntryEntity transactionEntryEntity : transactionEntryRepository.findAll()) {
            transactionEntries.addLast(new TransactionEntry(transactionEntryEntity));
        }

        // for (final TransactionEntryEntity transactionEntryEntity : transactionEntryRepository.findByTransactionId(this.transactionId)) {
        //     transactionEntries.addLast(new TransactionEntry(transactionEntryEntity));
        // }

        return transactionEntries;
    }

    // Properties
    private UUID transactionId;
    public UUID getTransactionId() {
        return this.transactionId;
    }
    public TransactionEntriesQuery setTransactionId(final UUID transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @Autowired
    private TransactionEntryRepository transactionEntryRepository;
}