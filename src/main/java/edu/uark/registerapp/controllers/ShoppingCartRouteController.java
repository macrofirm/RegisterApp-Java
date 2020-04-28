package edu.uark.registerapp.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.commands.transactions.TransactionEntriesQuery;
import edu.uark.registerapp.models.api.Product;


@Controller
@RequestMapping(value = "/shoppingCart")
public class ShoppingCartRouteController {
    @RequestMapping(value = "/{transactionId}", method = RequestMethod.GET)
    public ModelAndView showShoppingCart(@PathVariable final UUID transactionId) {
        ModelAndView modelAndView =
            new ModelAndView(ViewNames.SHOPPING_CART.getViewName());

            try {
                modelAndView.addObject(
                    ViewModelNames.TRANSACTION_ENTRIES.getValue(),
                    this.transactionEntriesQuery.setTransactionId(transactionId).execute());
            } catch (final Exception e) {
                modelAndView.addObject(
                    ViewModelNames.ERROR_MESSAGE.getValue(),
                    e.getMessage());
                modelAndView.addObject(
                    ViewModelNames.TRANSACTION_ENTRIES.getValue(),
                    (new Product[0]));
            }

        return modelAndView;
    }

    // Properties
	@Autowired
	private TransactionEntriesQuery transactionEntriesQuery;
}