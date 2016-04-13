package test.dao;

import test.entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 04.04.16.
 */
public interface EmployeeDAO {

    @test.dao.support.Connection
    Employee readEmployeeByID(Integer id ) throws SQLException;

    @test.dao.support.Connection
    List<Employee> readEmployees() throws SQLException;

    @test.dao.support.Connection
    void createEmployee(Employee employee) throws SQLException;

    @test.dao.support.Connection
    void updateEmployee(Employee employee) throws SQLException;

    @test.dao.support.Connection
    void deleteEmployee(Integer id) throws SQLException;

    @test.dao.support.Connection
    List<Employee> readEmployeeByIDDepartment(Integer id) throws SQLException;

    @test.dao.support.Connection
    boolean checkEmail(String email, Integer id) throws SQLException;

    @test.dao.support.Connection
    void createOrUpdateEmployee(Employee employee) throws  SQLException;
}
