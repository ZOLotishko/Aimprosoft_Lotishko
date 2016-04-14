package test.dao.implS;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import test.dao.EmployeeDAO;
import test.entity.Employee;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created on 13.04.16.
 */
public class EmployeeDaoImpl implements EmployeeDAO {
    private DataSource dataSource;

    @Override
    public Employee readEmployeeByID(Integer id) throws SQLException {

        String sql = "SELECT * From employee WHERE department_id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee1 = new Employee();
                employee1.setId(resultSet.getInt("id"));
                employee1.setName(resultSet.getString("name"));
                employee1.setEmail(resultSet.getString("email"));
                employee1.setDate(resultSet.getDate("date"));
                employee1.setSalary(resultSet.getDouble("salary"));
                employee1.setDepartment_id(resultSet.getInt("department_id"));
                return employee1;
            }
        });

        return employee;
    }

    @Override
    public List<Employee> readEmployees() throws SQLException {
        return null;
    }

    @Override
    public void createEmployee(Employee employee) throws SQLException {

        String sql = "INSERT into employee (name, email, date, salary, department_id) VALUES(?,?,?,?,?) ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] objects = new Object[]{employee.getId(), employee.getName(), employee.getEmail(), employee.getDate(), employee.getSalary(), employee.getDepartment_id()};
        int out = jdbcTemplate.update(sql, objects);

    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET name = ?, email = ?, date = ?, salary = ?  WHERE id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] objects = new Object[]{employee.getName(), employee.getEmail(), employee.getDate(), employee.getSalary(), employee.getDepartment_id()};
        int out = jdbcTemplate.update(sql, objects);
    }

    @Override
    public void deleteEmployee(Integer id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id = ? ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Employee> readEmployeeByIDDepartment(Integer id) throws SQLException {
        return null;
    }

    @Override
    public boolean checkEmail(String email, Integer id) throws SQLException {
        return false;
    }

    @Override
    public void createOrUpdateEmployee(Employee employee) throws SQLException {

    }
}
