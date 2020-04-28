package edu.uark.registerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.transactions.AddToCartCommand;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.TransactionEntry;

@RestController
@RequestMapping(value = "/api/transactionEntry")
public class TransactionEntryRestController {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody ApiResponse addToCart(
        @RequestBody final TransactionEntry transactionEntry
    ) {
        TransactionEntry createdTransactionEntry = this.addToCartCommand
            .setApiTransactionEntry(transactionEntry)
                .execute();
        return createdTransactionEntry;
    }

    // Properties
    @Autowired
    private AddToCartCommand addToCartCommand;
}