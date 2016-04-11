package test.controller.dep;

import test.controller.InternalController;
import test.exeption.ErrorException;
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
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer action = Utils.parseStringToInteger(request.getParameter("department_id"));

        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        try {
            departmentService.delete(action);
        } catch (ErrorException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/");
    }
}
