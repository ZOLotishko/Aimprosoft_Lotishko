package test.service;

import test.entity.Department;
import test.exeption.ValidationException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 04.04.16.
 */
public interface DepartmentService {

    void create(Department department) throws ValidationException, SQLException;
    Department read(Integer id) throws SQLException;
    void update(Department department) throws ValidationException, SQLException;
    void delete(Integer id) throws SQLException;
    List<Department> getAll() throws SQLException;
    void createOrUpdate(Department department) throws ValidationException, SQLException;
}
