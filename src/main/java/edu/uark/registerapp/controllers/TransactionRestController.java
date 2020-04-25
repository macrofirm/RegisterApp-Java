package edu.uark.registerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.transactions.StartTransactionCommand;
import edu.uark.registerapp.controllers.enums.QueryParameterNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.Transaction;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionRestController extends BaseRestController{
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody ApiResponse startTransaction(
        @RequestBody final Transaction transaction
    ) {
        Transaction createdTransaction = this.startTransactionCommand
            .setApiTransaction(transaction)
                .execute();
        createdTransaction.setRedirectUrl(
            ViewNames.PRODUCT_LISTING.getRoute().concat(
                this.buildInitialQueryParameter(
                    QueryParameterNames.TRANSACTION_ID.getValue(),
                    createdTransaction.getId().toString())));
        return createdTransaction;
    }

    // Properties 
    @Autowired
    private StartTransactionCommand startTransactionCommand;
}