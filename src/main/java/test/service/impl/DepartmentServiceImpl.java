package test.service.impl;

import test.dao.DaoFactory;
import test.dao.DepartmentDAO;
import test.dao.EmployeeDAO;
import test.dao.impl.EmployeeDAOImpl;
import test.entity.Department;
import test.entity.Employee;
import test.exeption.ValidationException;
import test.service.DepartmentService;
import test.validation.MyValidation;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created on 04.04.16.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private MyValidation myValidation = new MyValidation();
    private DepartmentDAO departmentDAO = DaoFactory.getDepartmentDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public void create(Department department) throws ValidationException, SQLException {

        Map<String, String> errors = myValidation.validation(department);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        }
        departmentDAO.createDepartment(department);
    }

    @Override
    public Department read(Integer id) throws SQLException {
        return departmentDAO.readDepartmentByID(id);
    }

    @Override
    public void update(Department department) throws ValidationException, SQLException {

        Map<String, String> errors = myValidation.validation(department);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        }
        departmentDAO.updateDepartment(department);

    }

    @Override
    public void delete(Integer id) throws  SQLException {

        List<Employee> employees = employeeDAO.readEmployeeByIDDepartment(id);
        if (!employees.isEmpty()) {
            for (Employee emp : employees) {
                employeeDAO.deleteEmployee(emp.getId());
            }
            departmentDAO.deleteDepartment(id);
        } else {
            departmentDAO.deleteDepartment(id);
        }
    }

    @Override
    public List<Department> getAll() throws SQLException {
        return departmentDAO.readDepartments();
    }

    @Override
    public void createOrUpdate(Department department) throws ValidationException, SQLException {

        Map<String, String> errors = myValidation.validation(department);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        }
        departmentDAO.createOrUpdateDepartment(department);
    }
}
