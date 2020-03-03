package edu.uark.registerapp.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.products.ProductCreateCommand; //edu.uark.registerapp.commands.employees.EmployeeCreateCommand?
import edu.uark.registerapp.commands.products.ProductDeleteCommand; //edu.uark.registerapp.commands.employees.EmployeeProductCommand?
import edu.uark.registerapp.commands.products.ProductUpdateCommand; //edu.uark.registerapp.commands.employees.EmployeeDeleteCommand?
import edu.uark.registerapp.commands.employees.helpers.EmployeeHelper;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.Product; //edu.uark.registerapp.models.api.Employee?

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
		@RequestMapping(value = "/", method = RequestMethod.POST)
		public @ResponseBody ApiResponse createEmployee(
			@RequestBody final Employee employee
			){
				return this.productCreateCommand  //HttpServletRequest?
					.setApiProduct(product)		  //HttpServletResponse?
					.execute();
			}
			
			@RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
			public @ResponseBody ApiReponse updateProduct(
					@PathVariable final UUID productId,
		@RequestBody final Product product
	) {

		return this.productUpdateCommand
			.setProductId(productId)
			.setApiProduct(product)
			.execute();
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public @ResponseBody ApiResponse deleteProduct(
		@PathVariable final UUID productId
	) {

		this.productDeleteCommand
			.setProductId(productId)
			.execute();

		return new ApiResponse();
	}

	// Properties
	@Autowired
	private ProductCreateCommand productCreateCommand;
	
	@Autowired
	private ProductDeleteCommand productDeleteCommand;
	
	@Autowired
	private ProductUpdateCommand productUpdateCommand;
}