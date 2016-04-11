package test.util;

import net.sf.oval.constraint.CheckWithCheck;
import test.dao.DepartmentDAO;
import test.dao.impl.DepartmentDAOImpl;
import test.entity.Department;

/**
 * Created on 08.04.16.
 */
public class CheckWithEntity implements CheckWithCheck.SimpleCheck {


    @Override
    public boolean isSatisfied(Object validatedObject, Object value) {
        try {
            DepartmentDAO departmentDAO = new DepartmentDAOImpl();
            return departmentDAO.checkName(((Department) validatedObject).getName(), ((Department) validatedObject).getId());
        } catch (Exception ignored) {}

        return false;
    }
}
