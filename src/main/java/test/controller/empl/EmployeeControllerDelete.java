package test.controller.empl;

import test.controller.InternalController;
import test.exeption.ErrorException;
import test.exeption.ValidationException;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;
import test.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sveta on 11.04.2016.
 */
public class EmployeeControllerDelete implements InternalController {

    EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            Integer id = Utils.parseStringToInteger(request.getParameter("id"));
            Integer depId = Utils.parseStringToInteger(request.getParameter("department_id"));
            employeeService.delete(id);
            String url = "/listEmployees?department_id=" + depId;
            response.sendRedirect(url);
        }catch (ErrorException e){

        }
    }
}
