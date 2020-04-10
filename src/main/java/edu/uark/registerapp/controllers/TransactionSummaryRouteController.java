package edu.uark.registerapp.controllers;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.activeUsers.ValidateActiveUserCommand;
import edu.uark.registerapp.commands.exceptions.UnauthorizedException;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.BaseRestController;
import edu.uark.registerapp.controllers.enums.QueryParameterMessages;
import edu.uark.registerapp.controllers.enums.QueryParameterNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.enums.EmployeeClassification;


//The 'Okay' button is going to route to 'Main Menu'
@Controller
@RequestMapping(value = "/")
public class TransactionSummaryRouteController extends BaseRouteController{

    

}