package test.dao.implS;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import test.dao.DepartmentDAO;
import test.entity.Department;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 13.04.16.
 */
public class DepartmentDaoImpl implements DepartmentDAO {

    DataSource dataSource;

    @Override
    public Department readDepartmentByID(Integer id) throws SQLException {

        String sql = "SELECT id, name FROM department WHERE id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Department department = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                Department department1 = new Department();
                department1.setId(resultSet.getInt("id"));
                department1.setName(resultSet.getString("name"));
                return department1;

            }
        });
        return department;
    }

    @Override
    public List<Department> readDepartments() throws SQLException {

        return null;
    }

    @Override
    public void createDepartment(Department department) throws SQLException {

        String sql = "INSERT into department ( name) VALUES (?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.update(sql, new Object[] {department.getName()});

    }

    @Override
    public void updateDepartment(Department department) throws SQLException {

        String sql = "UPDATE department SET name = ? WHERE id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] objects = new Object[]{sql, department.getName()};

    }

    @Override
    public void deleteDepartment(Integer id) throws SQLException {

        String sql = "DELETE FROM department WHERE id = ? ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public boolean checkName(String name, Integer id) throws SQLException {
        return false;
    }

    @Override
    public void createOrUpdateDepartment(Department department) throws SQLException {



    }
}
