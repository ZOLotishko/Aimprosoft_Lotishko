package test.dao.impl;

import test.dao.EmployeeDAO;
import test.entity.Employee;
import test.util.MYSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 04.04.16.
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    public Employee readEmployeeByID(Integer id) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "SELECT * FROM employee WHERE id = ?";
        ResultSet resultSet;
        Employee employee = new Employee();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            employee = fillEmpleyee(resultSet);

        }
        if (connection != null) {
            connection.close();
        }
        return employee;
    }

    public List<Employee> readEmployees() throws SQLException {

        Connection connection = MYSQLConnection.getConnection();

        String sql = "SELECT id, name, email, date, salary, department_id FROM employee";
        List<Employee> employees = new ArrayList<Employee>();
        ResultSet resultSet;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {

                Employee employee = fillEmpleyee(resultSet);
                employees.add(employee);
            }
        }
        if (connection != null) {
            connection.close();
        }
        return employees;
    }

    public void createEmployee(Employee employee) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "INSERT into employee (name, email, date, salary, department_id) VALUES(?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setDate(3, new java.sql.Date(employee.getDate().getTime()));
        preparedStatement.setDouble(4, employee.getSalary());
        preparedStatement.setInt(5, employee.getDepartment_id());

        preparedStatement.executeUpdate();

        if (connection != null) {
            connection.close();
        }

    }

    public void updateEmployee(Employee employee) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "UPDATE employee SET name = ?, email = ?, date = ?, salary = ?  WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setDate(3, new java.sql.Date(employee.getDate().getTime()));
        preparedStatement.setDouble(4, employee.getSalary());
        preparedStatement.setInt(5, employee.getId());
        preparedStatement.executeUpdate();

        if (connection != null) {
            connection.close();
        }
    }

    public void deleteEmployee(Integer id) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "DELETE FROM employee WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

        if (connection != null) {
            connection.close();
        }
    }

    public List<Employee> readEmployeeByIDDepartment(Integer id) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "SELECT * From employee WHERE department_id = ?";
        ResultSet resultSet;
        List<Employee> employees = new ArrayList<Employee>();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        if (resultSet != null) {
            while (resultSet.next()) {

                Employee employee = fillEmpleyee(resultSet);
                employees.add(employee);
            }
        }
        if (connection != null) {
            connection.close();
        }
        return employees;
    }

    public boolean checkEmail(String email, Integer id) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "SELECT * FROM employee WHERE email = ? ";
        ResultSet resultSet;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, email);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            if (resultSet.getInt("id") != id) {
                return false;
            }
        }
        if (connection != null) {
            connection.close();
        }
        return true;
    }

    @Override
    public void createOrUpdateEmployee(Employee employee) throws SQLException {

        String sql;
        Integer id = employee.getId();
        if (id == null) {
            sql = "INSERT into employee (name, email, date, salary, department_id) VALUES(?,?,?,?,?) ";
        } else {
            sql = "UPDATE employee SET name = ?, email = ?, date = ?, salary = ?  WHERE id = ?";
        }
        Connection connection = MYSQLConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setDate(3, new java.sql.Date(employee.getDate().getTime()));
        preparedStatement.setDouble(4, employee.getSalary());

        if (id == null) {
            preparedStatement.setInt(5, employee.getDepartment_id());
        } else {
            preparedStatement.setInt(5, employee.getId());
        }
        preparedStatement.executeUpdate();

        if (connection != null) {
            connection.close();
        }
    }

    private Employee fillEmpleyee(ResultSet resultSet) throws SQLException {
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
