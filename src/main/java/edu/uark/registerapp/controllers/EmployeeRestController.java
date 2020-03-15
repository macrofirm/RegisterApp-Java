package edu.uark.registerapp.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.products.ProductCreateCommand;
import edu.uark.registerapp.commands.products.ProductUpdateCommand;
import edu.uark.registerapp.commands.employees.EmployeeCreateCommand;
import edu.uark.registerapp.commands.employees.EmployeeUpdateCommand;
import edu.uark.registerapp.commands.employees.helpers.EmployeeHelper;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.Product;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
		@RequestMapping(value = "/", method = RequestMethod.POST)
		public @ResponseBody ApiResponse createEmployee(
			@RequestBody final Employee employee
			){
				return this.productCreateCommand  //HttpServletRequest?
					.setEmployee(employee)		  //HttpServletResponse?
					.execute();
			}
			
			@RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
			public @ResponseBody ApiReponse updateProduct(
					@PathVariable final UUID productId,
		@RequestBody final Product product
	) {

		return this.EmployeeUpdateCommand
			.setProductId(productId)
			.setApiProduct(product)
			.execute();
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse deleteProduct(
		@PathVariable final UUID productId
	) {

		return new ApiResponse();
	}

	// Properties
	@Autowired
	private EmployeeCreateCommand productCreateCommand;

	
	@Autowired
	private EmployeeUpdateCommand productUpdateCommand;
}