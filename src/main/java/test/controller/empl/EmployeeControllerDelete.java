package test.controller.empl;

import test.controller.InternalController;
import test.exeption.ErrorException;
import test.exeption.ValidationException;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;

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
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ValidationException, ErrorException {
        try {
            Integer id = Integer.parseInt((request.getParameter("delete")));
            Integer depId = Integer.parseInt((request.getParameter("department_id")));
            employeeService.delete(id);
            String url = "/listEmployee?id=" + depId;
            response.sendRedirect(url);
        }catch (ErrorException e){

        }
    }
}
