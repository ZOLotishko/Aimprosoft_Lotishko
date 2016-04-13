package test.service;

import test.entity.Employee;
import test.exeption.ValidationException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 05.04.16.
 */
public interface EmployeeService {

    void create(Employee employee) throws ValidationException, SQLException;
    Employee read(Integer id) throws SQLException;
    void update(Employee employee) throws ValidationException, SQLException;
    void delete(Integer id) throws SQLException;
    List<Employee> getAll() throws SQLException;
    List<Employee> getAllEmployeesInDepartment(Integer id) throws SQLException;
    void createOrUpdateEmployee(Employee employee) throws ValidationException, SQLException;

}
