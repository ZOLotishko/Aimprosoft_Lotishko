package test.dao;

import test.entity.Department;
import test.exeption.ErrorException;

import java.util.List;

/**
 * Created on 04.04.16.
 */
public interface DepartmentDAO {

    @test.dao.support.Connection
    Department readDepartmentByID(Integer id) throws ErrorException;

    @test.dao.support.Connection
    List<Department> readDepartments() throws ErrorException;

    @test.dao.support.Connection
    void createDepartment(Department department) throws ErrorException;

    @test.dao.support.Connection
    void updateDepartment(Department department) throws ErrorException;

    @test.dao.support.Connection
    void deleteDepartment(Integer id) throws ErrorException;

    @test.dao.support.Connection
    boolean checkName( String name, Integer id) throws ErrorException;

    @test.dao.support.Connection
    void createOrUpdateDepartment(Department department ) throws  ErrorException;
}
