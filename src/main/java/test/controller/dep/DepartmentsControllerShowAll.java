package test.controller.dep;

import test.controller.InternalController;
import test.entity.Department;
import test.exeption.ErrorException;
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

    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        List<Department> dep = null;
        try {
            dep = departmentService.getAll();
        } catch (ErrorException e) {
            e.printStackTrace();
        }
        request.setAttribute("dep", dep);
        request.getRequestDispatcher("/jsp/listDepartment.jsp").forward(request, response);
    }
}
