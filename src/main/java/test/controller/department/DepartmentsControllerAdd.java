package test.controller.department;

import org.springframework.stereotype.Component;
import test.controller.InternalController;
import test.entity.Department;
import test.exeption.ValidationException;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;
import test.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created on 05.04.16.
 */
@Component("/showAddList")
public class DepartmentsControllerAdd implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Department department = new Department(100, "name");
        String id = request.getParameter("id");
        department.setId(Utils.parseStringToInteger(id));
        department.setName(request.getParameter("name"));
        try {
            departmentService.createOrUpdate(department);
            response.sendRedirect("/");
        }catch (ValidationException e) {
            request.setAttribute("department", department);
            request.setAttribute("error", e.getError());
            request.getRequestDispatcher("/jsp/addDepartments.jsp").forward(request, response);
        } catch (SQLException e) {
            response.sendRedirect("/error");
        }
    }
}
