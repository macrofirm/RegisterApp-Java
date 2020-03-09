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
import edu.uark.registerapp.controllers.enums.ViewNames;

@Controller
public class EmployeeDetailRouteController{
	@RequestMapping(value = "/employeeDetail", method = RequestMethod.GET)  
	public ModelAndView start(@RequestParam final Map<String, String> queryParameters, HttpServletRequest request){
		return (new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName()));
	}
	
	@RequestMapping(value = "/employeeDetail{employeeId}", method = RequestMethod.GET)
	public ModelAndView startWithProduct(@PathVariable final UUID employeeId, Map<String, String> Parameters) {
		final ModelAndView modelAndView;
			new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName());
			ActiveEmployeeExistsQuery activeEmployeeExistsQuery;
		try {
				activeEmployeeExistsQuery.execute();

		} catch (final Exception e) {
			
		}

		return modelAndView;
	}

	// Properties
	@Autowired
	private ActiveEmployeeExistsQuery activeEmployeeExistsQuery;

}
