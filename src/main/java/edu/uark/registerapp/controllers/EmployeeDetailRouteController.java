package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.employees.ActiveEmployeeExistsQuery;
import edu.uark.registerapp.commands.employees.EmployeeQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.controllers.MainMenuRouteController;

@Controller
@RequestMapping(value = "/employeeDetail")
public class EmployeeDetailRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(@RequestParam Map<String, String> object, HttpServletRequest request){
		ModelAndView modelAndView;
		try {
			activeEmployeeExistsQuery.execute();
			modelAndView = new ModelAndView(ViewModelNames.IS_ELEVATED_USER.getValue());
			modelAndView = new ModelAndView(ViewNames.SIGN_IN.getViewName());
			
		}catch(NotFoundException e) {
			modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());

		}
		return modelAndView;
		/*
		try{
			activeEmployeeExistsQuery.execute();
			modelAndView = new ModelAndView(ViewNames.SIGN_IN.getViewName());
		}catch(NotFoundException e){
			if(ViewModelNames.IS_ELEVATED_USER.getValue(true))
			{
				modelAndView = new ModelAndView(ViewNames.SIGN_IN.getViewName());
			}else{
				modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());
				modelAndView = new ModelAndView(ViewNames.MAIN_MENU.getviewName());
			}

		}


		*/
		/*
			activeEmployeeExistsQuery.execute();
			modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());
		} else{
			modelAndView = new ModelAndView(ViewNames.MAIN_MENU.getViewName());
		}*/
		return modelAndView;*/
	}

	@RequestMapping(value="/{employeeId}", method = RequestMethod.GET)
	public ModelAndView startWithEmployee(@PathVariable final UUID id, @RequestParam Map<String, String> object, HttpServletRequest request) {
		final ModelAndView modelAndView = new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());

		try{
			ModelAndView(
					ViewModelNames.EMPLOYEE.getValue(),
					this.employeeQuery.execute());
		} catch (final Exception e) {
			modelAndView.addObject(
				ViewModelNames.ERROR_MESSAGE.getValue(),
				e.getMessage());
			modelAndView.addObject(
				ViewModelNames.EMPLOYEE.getValue(),
				(new Employee()));

		}
		return modelAndView;
	}
	@Autowired
	private ActiveEmployeeExistsQuery activeEmployeeExistsQuery;

}
