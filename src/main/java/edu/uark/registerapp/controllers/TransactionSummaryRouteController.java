package edu.uark.registerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uark.registerapp.controllers.enums.ViewNames;


@Controller
@RequestMapping(value = "/transactionSummary")
public class TransactionSummaryRouteController extends BaseRouteController{
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showTransactionView() {
        ModelAndView modelAndView =
            new ModelAndView(ViewNames.TRANSACTION_SUMMARY.getViewName());
        
        
        return modelAndView;
    }
}