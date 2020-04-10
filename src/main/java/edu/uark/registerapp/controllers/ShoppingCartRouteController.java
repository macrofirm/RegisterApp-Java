package edu.uark.registerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.uark.registerapp.controllers.enums.ViewNames;


@Controller
@RequestMapping(value = "/shoppingCart")
public class ShoppingCartRouteController {
    @RequestMapping(value = "/")
    public ModelAndView showShoppingCart() {
        ModelAndView modelAndView =
            new ModelAndView(ViewNames.SHOPPING_CART.getViewName());

        return modelAndView;
    }
}