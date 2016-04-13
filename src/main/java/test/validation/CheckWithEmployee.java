package test.validation;

import net.sf.oval.constraint.CheckWithCheck;
import test.dao.EmployeeDAO;
import test.dao.impl.EmployeeDAOImpl;
import test.entity.Employee;

/**
 * Created by
 */
public class CheckWithEmployee implements CheckWithCheck.SimpleCheck {
    @Override
    public boolean isSatisfied(Object validatedObject, Object value) {

        try {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();
            return employeeDAO.checkEmail(((Employee) validatedObject).getEmail(), ((Employee) validatedObject).getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
