package edu.uark.registerapp.commands.transactions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.entities.ProductEntity;
import edu.uark.registerapp.models.entities.TransactionEntryEntity;
import edu.uark.registerapp.models.repositories.ProductRepository;
import edu.uark.registerapp.models.repositories.TransactionEntryRepository;
import edu.uark.registerapp.models.repositories.TransactionRepository;
import edu.uark.registerapp.models.entities.TransactionEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.models.entities.EmployeeEntity;

@Service
public class TransactionCommitCommand implements VoidCommandInterface{
    @Transactional
    @Override
    public void execute() {
        final List<TransactionEntryEntity> queriedTransactionEntryEntities =
            this.transactionEntryRepository.findByTransactionId(transactionId);
        double total = 0;
        int totalNumSold = 0;
        for (TransactionEntryEntity transactionEntryEntity : queriedTransactionEntryEntities) {
            Optional<ProductEntity> productEntity = productRepository.findById(transactionEntryEntity.getProductId());
            if (!productEntity.isPresent()) {
                throw new NotFoundException("Product");
            }
            productEntity.get().setQuantitySold(productEntity.get().getQuantitySold() + transactionEntryEntity.getQuantity());
            productEntity.get().setCount(productEntity.get().getCount() - transactionEntryEntity.getQuantity());

            double num = transactionEntryEntity.getPrice() * transactionEntryEntity.getQuantity();
            total += num;
            totalNumSold += transactionEntryEntity.getQuantity();
            
            productEntity.get().setProductSales(productEntity.get().getProductSales() + num);

            this.productRepository.save(productEntity.get());
        }
        final Optional<TransactionEntity> updateTotal = this.transactionRepository.findById(transactionId);
        updateTotal.get().setTotal(total);
        final Optional<EmployeeEntity> updateEmployee = this.employeeRepository.findById(this.transactionRepository.findById(transactionId).get().getCashierId());
        updateEmployee.get().setEmployeeSales(total);
        updateEmployee.get().setQuantitySold(totalNumSold);
    }

    // Properites
    private UUID transactionId;
    public UUID getTransactionId() {
        return this.transactionId;
    }
    public TransactionCommitCommand setTransactionId(final UUID transactionId) {
        this.transactionId = transactionId;;
        return this;
    }

    @Autowired
    private TransactionEntryRepository transactionEntryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
}