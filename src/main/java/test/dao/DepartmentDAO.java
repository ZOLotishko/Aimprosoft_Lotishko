package test.dao;

import test.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 04.04.16.
 */
public interface DepartmentDAO {

    @test.dao.support.Connection
    Department readDepartmentByID(Integer id) throws SQLException;

    @test.dao.support.Connection
    List<Department> readDepartments() throws SQLException;

    @test.dao.support.Connection
    void createDepartment(Department department) throws SQLException;

    @test.dao.support.Connection
    void updateDepartment(Department department) throws SQLException;

    @test.dao.support.Connection
    void deleteDepartment(Integer id) throws SQLException;

    @test.dao.support.Connection
    boolean checkName( String name, Integer id) throws SQLException;

    @test.dao.support.Connection
    void createOrUpdateDepartment(Department department ) throws SQLException;
}
