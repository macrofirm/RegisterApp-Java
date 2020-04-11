package edu.uark.registerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.uark.registerapp.controllers.enums.ViewNames;


//The 'Okay' button is going to route to 'Main Menu'
@Controller
@RequestMapping(value = "/transactionSummary")
public class TransactionSummaryRouteController extends BaseRouteController{
    public ModelAndView showTransactionView() {
        ModelAndView modelAndView =
            new ModelAndView(ViewNames.TRANSACTION_SUMMARY.getViewName());
        
        return modelAndView;
    }
}