package test.controller.dep;

import test.controller.InternalController;
import test.entity.Department;
import test.exeption.ErrorException;
import test.service.impl.DepartmentServiceImpl;
import test.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 07.04.16.
 */
public class DepartmentsControllerShowAddList implements InternalController {

    DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("department_id");

        if(id!=null){
            Department department = null;
            try {
                department = departmentService.read(Utils.parseStringToInteger(id));
            } catch (ErrorException e) {
                e.printStackTrace();
            }
            if(department!=null){
                request.setAttribute("department", department);
            }
        }
        request.getRequestDispatcher("jsp/addDepartments.jsp").forward(request, response);
    }
}
