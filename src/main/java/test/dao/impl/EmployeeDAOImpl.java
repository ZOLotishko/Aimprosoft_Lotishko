package test.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import test.dao.EmployeeDAO;
import test.entity.Employee;
import test.util.Utils;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 04.04.16.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createEmployee(Employee employee) {
        String sql = "INSERT into employee (name, email, date, salary, department_id) VALUES(?,?,?,?,?) ";
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[]{employee.getName(), employee.getEmail(), employee.getDate(), employee.getSalary(), employee.getDepartment_id()});
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Employee readEmployeeByID(Integer id) {

        String sql = "SELECT * From employee WHERE department_id = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Employee.class));

        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        String sql = "SELECT id, name, email, date, salary, department_id FROM employee ";
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<Employee> employees = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Employee employee = new Employee();
            employee.setId(Utils.parseStringToInteger(String.valueOf(row.get("id"))));
            employee.setName((String) row.get("name"));
            employee.setEmail((String) row.get("email"));
            employee.setDate(Utils.parseStringToDate((String) row.get("date")));
            employee.setSalary(Utils.parseStringToDouble((String) row.get("salary")));
            employee.setDepartment_id(Utils.parseStringToInteger((String) row.get("department_id")));
            employees.add(employee);
        }

        return null;
    }


    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET name = ?, email = ?, date = ?, salary = ?  WHERE id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] objects = new Object[]{employee.getName(), employee.getEmail(), employee.getDate(), employee.getSalary(), employee.getDepartment_id()};
        int out = jdbcTemplate.update(sql, objects);
    }

    @Override
    public void deleteEmployee(Integer id) {
        String sql = "DELETE FROM employee WHERE id = ? ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Employee> readEmployeeByIDDepartment(Integer id) {
        return null;
    }

    @Override
    public boolean checkEmail(String email, Integer id) {
        return false;
    }

    @Override
    public void createOrUpdateEmployee(Employee employee) {

    }
}
