package edu.uark.registerapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.commands.employees.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.commands.employees.EmployeeSignInCommand;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.models.api.EmployeeSignIn;

@Controller
@RequestMapping(value = "/signIn")
public class SignInRouteController extends BaseRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(@RequestParam final Map<String, String> queryParameters) {
		ModelAndView modelAndView;
		try {
			activeEmployeeExistsQuery.execute();
			modelAndView = new ModelAndView(ViewNames.SIGN_IN.getViewName());
		} catch (NotFoundException e) {
			modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView performSignIn(
			final EmployeeSignIn apiEmployeeSignIn,
			final HttpServletRequest request
	) {
		ModelAndView modelAndView;
		try {
			employeeSignInCommand.setApiEmployeeSignIn(apiEmployeeSignIn).setSessionKey(request.getSession().getId()).execute();
			modelAndView = new ModelAndView(REDIRECT_PREPEND.concat(ViewNames.MAIN_MENU.getRoute()));
		} catch (UnprocessableEntityException e) {
			modelAndView = new ModelAndView(ViewNames.SIGN_IN.getViewName());
			modelAndView.addObject(ViewModelNames.ERROR_MESSAGE.getValue(), "Sign in was unsuccessful.");
		}
		return modelAndView;
	}

	// Properties
	@Autowired
	private ActiveEmployeeExistsQuery activeEmployeeExistsQuery;

	@Autowired
	private EmployeeSignInCommand employeeSignInCommand;
}
