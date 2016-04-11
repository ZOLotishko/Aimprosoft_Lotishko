package test.controller.empl;

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
import java.util.Date;

/**
 * Created on 06.04.16.
 */
public class AddEmployeeController implements InternalController {

    EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ErrorException, ValidationException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String d = request.getParameter("date");
        Date date = Utils.parseStringToDate(d);
        Double salary = Utils.parseStringToDouble(request.getParameter("salary"));
        Integer dep_id = Integer.parseInt(request.getParameter("department_id"));

        Employee employee = new Employee(name, email, date, salary, dep_id);

        try {
            if (id.isEmpty()){
                employeeService.create(employee);
            }else{
                employee.setId(Integer.valueOf(id));
                employeeService.update(employee);
            }
        }catch (ValidationException e){
            request.setAttribute("emp", employee);
            request.setAttribute("error", e.getError() );
            response.sendRedirect("/addEmployee?department_id=" + dep_id);
        }
        response.sendRedirect("/listEmployee?department_id=" + employee.getDepartment_id());
    }
}
