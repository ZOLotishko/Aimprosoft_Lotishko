package test.controller.department;

import test.controller.InternalController;
import test.entity.Department;
import test.exeption.ErrorException;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 04.04.16.
 */
public class DepartmentsControllerShowAll implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,  ErrorException{
        List<Department> dep = departmentService.getAll();
        request.setAttribute("dep", dep);
        request.getRequestDispatcher("/jsp/listDepartment.jsp").forward(request, response);
    }
}
