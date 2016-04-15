package test.dao.impl;


import org.springframework.jdbc.core.RowMapper;
import test.entity.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created on 14.04.16.
 */
@SuppressWarnings("rawtypse")
public class DepartmentRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Department department = new Department(100, "name");
        department.setId(resultSet.getInt("id"));
        department.setName(resultSet.getString("name"));
        return department;
    }
}
