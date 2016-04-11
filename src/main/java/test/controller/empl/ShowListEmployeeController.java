package test.controller.empl;

import test.controller.InternalController;
import test.entity.Employee;
import test.exeption.ErrorException;
import test.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 06.04.16.
 */
public class ShowListEmployeeController implements InternalController {

    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ErrorException {

        String id = request.getParameter("department_id");
        if(id!=null){
            Integer depId = Integer.valueOf(id);
            List<Employee> employees = employeeService.getAllEmployeesInDepartment(depId);
            if(employees!=null){
                request.setAttribute("department_id",depId);
                request.setAttribute("emp",employees);
            }
        }
        request.getRequestDispatcher("jsp/listEmployee.jsp").forward(request, response);
    }
}
