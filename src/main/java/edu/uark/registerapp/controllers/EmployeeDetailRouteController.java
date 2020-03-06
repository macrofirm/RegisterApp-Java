package edu.uark.registerapp.controllers;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.employees.EmployeeQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Employee;

@Controller
@RequestMapping(value = "/employeeDetail")
public class EmployeeDetailRouteController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start(){
		return (new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName()))
			.addObject(
				ViewModelNames.EMPLOYEE.getValue(),
				(new Employee()));
	}

	@RequestMapping(value="/{employeeId}", method = RequestMethod.GET)
	public ModelAndView startWithEmployee(@PathVariable final UUID id) {
		final ModelAndView modelAndView =
			new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());

		try{
			modelAndView(
					ViewModelNames.EMPLOYEE.getValue(),
					this.employeeQuery.setId(id).execute());
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
	private EmployeeQuery employeeQuery;
}
