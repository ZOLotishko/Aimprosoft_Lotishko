package test.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import test.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created on 14.04.16.
 */
@SuppressWarnings("rawtypes")
public class EmployeeRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setEmail(resultSet.getString("email"));
        employee.setDate(resultSet.getDate("date"));
        employee.setSalary(resultSet.getDouble("salary"));
        employee.setDepartment_id(resultSet.getInt("department_id"));

        return employee;
    }
}
