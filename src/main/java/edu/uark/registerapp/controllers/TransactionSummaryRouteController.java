package edu.uark.registerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.commands.products.ProductsQuery;


//The 'Okay' button is going to route to 'Main Menu'
@Controller
@RequestMapping(value = "/transactionSummary")
public class TransactionSummaryRouteController extends BaseRouteController{
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showTransactionView() {
        ModelAndView modelAndView =
            new ModelAndView(ViewNames.TRANSACTION_SUMMARY.getViewName());
        
        return modelAndView;
    }

    @Autowired
    private ProductsQuery productsQuery;
}