package test.dao.impl;

import test.dao.EmployeeDAO;
import test.entity.Employee;
import test.exeption.ErrorException;
import test.util.MYSQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created on 04.04.16.
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    public Employee readEmployeeByID(Integer id) throws ErrorException{

        Connection connection = MYSQLConnection.getConnection();
        String sql = "SELECT * FROM employee WHERE id = ?";
        ResultSet resultSet = null;
        Employee employee = new Employee();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDate(resultSet.getDate("date"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDepartment_id(resultSet.getInt("department_id"));

            }
        } catch (SQLException e) {
            throw new ErrorException("");
        }
        return employee;
    }

    public List<Employee> readEmployees() throws ErrorException{

        Connection connection = MYSQLConnection.getConnection();

        String sql = "SELECT id, name, email, date, salary, department_id FROM employee";
        List<Employee> employees = new ArrayList<Employee>();
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {

                    Employee employee = new Employee();

                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setDate(resultSet.getDate("date"));
                    employee.setSalary(resultSet.getDouble("salary"));
                    employee.setDepartment_id(resultSet.getInt("department_id"));

                    employees.add(employee);
                }
            }

        } catch (SQLException e) {
            throw new ErrorException("");
        }
        return employees;
    }

    public void createEmployee(Employee employee) throws ErrorException{

        Connection connection = MYSQLConnection.getConnection();
        String sql = "INSERT into employee (name, email, date, salary, department_id) VALUES(?,?,?,?,?) ";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setDate(3,  new java.sql.Date(employee.getDate().getTime()));
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getDepartment_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw  new ErrorException("");
        }

    }

    public void updateEmployee(Employee employee) throws ErrorException{

        Connection connection = MYSQLConnection.getConnection();
        String sql = "UPDATE employee SET name = ?, email = ?, date = ?, salary = ?  WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(employee.getDate().getTime()));
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ErrorException("");
        }
    }

    public void deleteEmployee(Integer id) throws ErrorException{

        Connection connection = MYSQLConnection.getConnection();
        String sql = "DELETE FROM employee WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ErrorException("");
        }
    }

    public List<Employee> readEmployeeByIDDepartment(Integer id) throws ErrorException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "SELECT * From employee WHERE department_id = ?";
        ResultSet resultSet ;
        List<Employee> employees = new ArrayList<Employee>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {

                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setDate(resultSet.getDate("date"));
                    employee.setSalary(resultSet.getDouble("salary"));
                    employees.add(employee);
                }
            }
        }catch (SQLException e){
            throw new ErrorException("");
        }
        return employees;
    }

    //    @Override
    public boolean checkEmail(String email, Integer id) throws ErrorException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "SELECT * FROM employee WHERE email = ? ";
        ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if(resultSet.getInt("id")!=id){
                    return false;
                }
            }
        }
        catch (SQLException e) {
            throw new ErrorException("");
        }
        return true;
    }

    @Override
    public void createOrUpdateEmployee(Employee employee) throws ErrorException {

        String sql;
        Integer id = employee.getId();
        if (id == null){
            sql = "INSERT into employee (name, email, date, salary, department_id) VALUES(?,?,?,?,?) ";
        }else {
            sql = "UPDATE employee SET name = ?, email = ?, date = ?, salary = ?  WHERE id = ?";
        }
        Connection connection = MYSQLConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(employee.getDate().getTime()));
            preparedStatement.setDouble(4, employee.getSalary());

            if(id == null) {
                preparedStatement.setInt(5, employee.getDepartment_id());
            }else {
                preparedStatement.setInt(5, employee.getId());
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ErrorException("");
        }
    }
}
