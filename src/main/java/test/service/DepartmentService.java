package test.service;

import test.entity.Department;
import test.exeption.ErrorException;
import test.exeption.ValidationException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 04.04.16.
 */
public interface DepartmentService {

    void create(Department department) throws ValidationException, ErrorException;
    Department read(Integer id) throws ErrorException;
    void update(Department department) throws ValidationException, ErrorException;
    void delete(Integer id) throws ErrorException;
    List<Department> getAll() throws ErrorException;
    void createOrUpdate(Department department) throws ValidationException, ErrorException;
}
