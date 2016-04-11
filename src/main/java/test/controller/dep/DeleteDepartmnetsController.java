package test.controller.dep;

import test.controller.InternalController;
import test.exeption.ErrorException;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 05.04.16.
 */
public class DeleteDepartmnetsController implements InternalController {
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ErrorException {

        int action = Integer.parseInt(request.getParameter("delete"));

        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        departmentService.delete(action);

        response.sendRedirect("/");
    }
}
