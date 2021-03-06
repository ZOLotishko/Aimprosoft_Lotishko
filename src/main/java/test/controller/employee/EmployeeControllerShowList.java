package test.controller.employee;

import test.controller.InternalController;
import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;
import test.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 06.04.16.
 */
public class EmployeeControllerShowList implements InternalController {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String id = request.getParameter("department_id");

        if(id!=null){
            Integer depId = Utils.parseStringToInteger(id);
            List<Employee> employees = null;
            try {
                employees = employeeService.getAllEmployeesInDepartment(depId);
            } catch (SQLException e) {
                response.sendRedirect("/error");
            }
            if(employees!=null){
                request.setAttribute("department_id",depId);
                request.setAttribute("emp",employees);
            }
        }
        request.getRequestDispatcher("jsp/listEmployee.jsp").forward(request, response);
    }
}
