package test.controller.empl;

import test.controller.InternalController;
import test.entity.Employee;
import test.exeption.ErrorException;
import test.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 07.04.16.
 */
public class ShowEmployeeAddListController implements InternalController{

    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ErrorException {

        String id = request.getParameter("id");
        if(id!=null){
            Employee employee = employeeService.read(Integer.parseInt(id));
            if(employee!=null){
                request.setAttribute("emp", employee);
            }
        }
        request.setAttribute("department_id", request.getParameter("department_id"));
        request.getRequestDispatcher("jsp/addEmployee.jsp").forward(request, response);

    }
}
