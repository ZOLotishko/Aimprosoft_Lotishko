package test.controller.department;

import test.controller.InternalController;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;
import test.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 05.04.16.
 */
public class DepartmentsControllerDelete implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer action = Utils.parseStringToInteger(request.getParameter("department_id"));

        try {
            departmentService.delete(action);
        } catch (Exception e) {
            response.sendRedirect("/error");
        }
        response.sendRedirect("/");
    }
}
