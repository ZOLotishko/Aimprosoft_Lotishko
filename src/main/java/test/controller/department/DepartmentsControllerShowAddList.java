package test.controller.department;

import org.springframework.stereotype.Component;
import test.controller.InternalController;
import test.entity.Department;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;
import test.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created on 07.04.16.
 */
@Component("/addDepartment")
public class DepartmentsControllerShowAddList implements InternalController {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("department_id");

        if(id!=null){
            Department department = null;
            try {
                department = departmentService.read(Utils.parseStringToInteger(id));
            } catch (SQLException e) {
                response.sendRedirect("/error");
            }

            if(department!=null){
                request.setAttribute("department", department);
            }
        }
        request.getRequestDispatcher("jsp/addDepartments.jsp").forward(request, response);
    }
}
