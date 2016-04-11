package test.service;

import test.entity.Employee;
import test.exeption.ErrorException;
import test.exeption.ValidationException;

import java.util.List;

/**
 * Created on 05.04.16.
 */
public interface EmployeeService {

    void create(Employee employee) throws ValidationException, ErrorException;
    Employee read(Integer id) throws ErrorException;
    void update(Employee employee) throws ValidationException, ErrorException;
    void delete(Integer id) throws ErrorException;
    List<Employee> getAll() throws ErrorException;
    List<Employee> getAllEmployeesInDepartment(Integer id) throws ErrorException;

}
