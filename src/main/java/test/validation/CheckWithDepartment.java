package test.validation;

import net.sf.oval.constraint.CheckWithCheck;
import test.dao.DepartmentDAO;
import test.dao.impl.DepartmentDAOImpl;
import test.entity.Department;


/**
 * Created
 */
public class CheckWithDepartment implements CheckWithCheck.SimpleCheck {

    @Override
    public boolean isSatisfied(Object validatedObject, Object value) {

        try {
            DepartmentDAO departmentService = new DepartmentDAOImpl();
            return departmentService.checkName(((Department) validatedObject).getName(), ((Department) validatedObject).getId());
        }
        catch (Exception e){

        }
        return false;
    }
}
