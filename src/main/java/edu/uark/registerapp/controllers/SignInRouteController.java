package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

@Controller
@RequestMapping(value = "/signIn")
public class SignInRouteController extends BaseRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(@RequestParam final Map<String, String> queryParameters) {
		ModelAndView modelAndView;
		if (true/* employees exist */) {
			modelAndView = new ModelAndView(ViewNames.SIGN_IN.getViewName());
		} else {
			modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(
			final EmployeeSignIn credentials,
			final HttpServletRequest request
	) {

		// TODO: Use the credentials provided in the request body
		//  and the "id" property of the (HttpServletRequest)request.getSession() variable
		//  to sign in the user
		ModelAndView modelAndView;

		if (true/* credentials verified */) {
			ActiveUserEntity entity = new ActiveUserEntity();
			entity.setClassification(0/*classification*/);
			entity.setEmployeeId(UUID.randomUUID()/*EmpId*/);
			entity.setName("name"/*name*/);
			entity.setSessionKey("sessKey"/*sessKey*/);
			modelAndView = new ModelAndView(REDIRECT_PREPEND.concat(ViewNames.MAIN_MENU.getRoute()));
		} else {
			modelAndView = new ModelAndView(ViewNames.SIGN_IN.getViewName());
			modelAndView.addObject(ViewModelNames.ERROR_MESSAGE.getValue(), "Sign in was unsuccessful.");
		}
		return modelAndView;
	}
}
