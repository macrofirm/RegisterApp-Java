import org.springframework.stereotype.Controller;

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