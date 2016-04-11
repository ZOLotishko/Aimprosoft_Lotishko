package test.controller.dep;

import test.controller.InternalController;
import test.entity.Department;
import test.exeption.ErrorException;
import test.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 07.04.16.
 */
public class ShowAddListController implements InternalController {

    DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ErrorException {

        String id = request.getParameter("id");

        if(id!=null){
            Department department = departmentService.read(Integer.valueOf(id));
            if(department!=null){
                request.setAttribute("department",department);
            }
        }
        request.getRequestDispatcher("jsp/addDepartments.jsp").forward(request, response);
    }
}
