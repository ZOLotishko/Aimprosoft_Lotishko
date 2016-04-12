package test.controller.employee;

import test.controller.InternalController;
import test.entity.Employee;
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
 * Created on 06.04.16.
 */
public class EmployeeControllerAdd implements InternalController {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException , ErrorException{

        Employee employee = new Employee();

        employee.setId(Utils.parseStringToInteger(request.getParameter("id")));
        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setDate(Utils.parseStringToDate(request.getParameter("date")));
        employee.setSalary(Utils.parseStringToDouble(request.getParameter("salary")));
        employee.setDepartment_id(Utils.parseStringToInteger(request.getParameter("department_id")));

        try {
            employeeService.createOrUpdateEmployee(employee);
            response.sendRedirect("/listEmployees?department_id=" + employee.getDepartment_id());
        }
        catch (ValidationException e){
            request.setAttribute("emp", employee);
            request.setAttribute("department_id", request.getParameter("department_id"));
            request.setAttribute("error", e.getError() );
            request.getRequestDispatcher("/jsp/addEmployee.jsp").forward(request, response);

        }
    }
}
