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
            Integer id = ((Employee) validatedObject).getId();
            String email = ((Employee) validatedObject).getEmail();
//            return employeeDAO.checkEmployeeEmail(((Employee) validatedObject).getEmail(), ((Employee) validatedObject).getId() );
            return employeeDAO.checkEmail(email, id);

       } catch (Exception e) {}
        return false;
    }
}
