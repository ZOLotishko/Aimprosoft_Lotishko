package test.controller.department;

import test.controller.InternalController;
import test.entity.Department;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 04.04.16.
 */
public class DepartmentsControllerShowAll implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Department> dep = null;
        try {
            dep = departmentService.getAll();
        } catch (SQLException e) {
            response.sendRedirect("/error");
        }
        request.setAttribute("dep", dep);
        request.getRequestDispatcher("/jsp/listDepartment.jsp").forward(request, response);
    }
}
