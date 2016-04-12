package test.service.impl;

import test.dao.DaoFactory;
import test.dao.EmployeeDAO;
import test.entity.Employee;
import test.exeption.ErrorException;
import test.exeption.ValidationException;
import test.service.EmployeeService;
import test.validation.MyValidation;

import java.util.List;
import java.util.Map;

/**
 * Created on 05.04.16.
 */
public class EmployeeServiceImpl  implements EmployeeService{
    private MyValidation myValidation = new MyValidation();
    private EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();
    @Override
    public void create(Employee employee) throws ValidationException, ErrorException {
        Map<String, String> errors = myValidation.validation(employee);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        }
        employeeDAO.createEmployee(employee);
    }

    @Override
    public Employee read(Integer id) throws ErrorException{
        return employeeDAO.readEmployeeByID(id);
    }

    @Override
    public void update(Employee employee) throws ValidationException, ErrorException {
        Map<String, String> errors = myValidation.validation(employee);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        }
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void delete(Integer id) throws ErrorException {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public List<Employee> getAll() throws ErrorException {
        return employeeDAO.readEmployees();
    }

    @Override
    public List<Employee> getAllEmployeesInDepartment(Integer id) throws ErrorException {
        return employeeDAO.readEmployeeByIDDepartment(id);
    }

    @Override
    public void createOrUpdateEmployee(Employee employee) throws ValidationException, ErrorException {
        Map<String, String> errors = myValidation.validation(employee);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        }
        employeeDAO.createOrUpdateEmployee(employee);
    }
}
