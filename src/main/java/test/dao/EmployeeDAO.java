package test.dao;

import test.entity.Employee;
import test.exeption.ErrorException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 04.04.16.
 */
public interface EmployeeDAO {

    @test.dao.support.Connection
    Employee readEmployeeByID(Integer id ) throws ErrorException;

    @test.dao.support.Connection
    List<Employee> readEmployees() throws ErrorException;

    @test.dao.support.Connection
    void createEmployee(Employee employee) throws ErrorException;

    @test.dao.support.Connection
    void updateEmployee(Employee employee) throws ErrorException;

    @test.dao.support.Connection
    void deleteEmployee(Integer id) throws ErrorException;

    @test.dao.support.Connection
    List<Employee> readEmployeeByIDDepartment(Integer id) throws ErrorException;

    @test.dao.support.Connection
    boolean checkEmail(String email, Integer id) throws ErrorException;

    @test.dao.support.Connection
    void createOrUpdateEmployee(Employee employee) throws  ErrorException;
}
