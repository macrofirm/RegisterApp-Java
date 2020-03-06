package edu.uark.registerapp.controllers;
package edu.uark.registerapp.controllers.enums;

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
public class EmployeeDetailRouteController{
	@RequestMapping(value = "/employeeDetail", method = RequestMethod.GET)  
	public ModelAndView start(@RequestParam final Map<String, String> queryParameters, HttpServletRequest request){
		return (new ModelAndView(ViewNames.EMPLOYEE_DETAIL.getViewName()))
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
