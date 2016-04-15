package test.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import test.dao.DepartmentDAO;
import test.entity.Department;
import test.util.Utils;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 04.04.16.
 */
@Repository("departmentDAO")
public class DepartmentDAOImpl implements DepartmentDAO {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createDepartment(Department department) {

        String sql = "INSERT into department ( id, name) VALUES (?,?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[]{department.getId(), department.getName()});

    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Department readDepartmentByID(Integer id) {
        try {
            String sql = "SELECT id, name FROM department WHERE id = ?";
            jdbcTemplate = new JdbcTemplate(dataSource);
            return (Department) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Department.class));
        } catch (EmptyResultDataAccessException e) {
            Department department = new Department();
            return department;
        }

    }

    @Override
    @SuppressWarnings("rawtyps")
    public List<Department> readDepartments() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT id, name FROM department ";
        List<Department> departments = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Department department = new Department();
            department.setId(Utils.parseStringToInteger(String.valueOf(row.get("id"))));
            department.setName((String) row.get("name"));
            departments.add(department);
        }

        return departments;
    }


    public String findNameById(Integer id) {
        String sql = "SELECT name FROM department WERE id = ?";
        String name = (String) jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
        return name;
    }

    @Override
    public void updateDepartment(Department department) {

        String sql = "UPDATE department SET name = ? WHERE id = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[]{department.getId(), department.getName()});
    }

    @Override
    public void deleteDepartment(Integer id) {

        String sql = "DELETE FROM department WHERE id = ? ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public boolean checkName(String name, Integer id) {
        return false;
    }

    @Override
    public void createOrUpdateDepartment(Department department) {
        String sql;
        Integer id = department.getId();
        if (id == null) {
            sql = "INSERT into department ( id, name) VALUES (?,?)";
        } else {
            sql = "UPDATE department SET name = ? WHERE id = ?";
        }
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[]{department.getId(), department.getName()});


    }
}
