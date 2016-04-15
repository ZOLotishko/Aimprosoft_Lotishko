package test.controller.employee;

import org.springframework.stereotype.Component;
import test.controller.InternalController;
import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created on 07.04.16.
 */
@Component("/addEmployee")
public class EmployeeControllerShowAddList implements InternalController{

    private EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String id = request.getParameter("id");
        if(id!=null){
            Employee employee = null;
            try {
                employee = employeeService.read(Integer.parseInt(id));
            } catch (SQLException e) {
                response.sendRedirect("/error");
            }
            if(employee!=null){
                request.setAttribute("emp", employee);
                request.setAttribute("department_id", request.getParameter("department_id"));
            }
        }
        request.getRequestDispatcher("jsp/addEmployee.jsp").forward(request, response);
    }
}
