package test.dao.impl;

import test.dao.DepartmentDAO;
import test.entity.Department;
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
public class DepartmentDAOImpl implements DepartmentDAO {

    public Department readDepartmentByID(Integer id) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "SELECT id, name FROM department WHERE id = ?";
        ResultSet resultSet;
        Department department = new Department();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            department = fillDepartment(resultSet);
        }
        if (connection != null) {
            connection.close();
        }
        return department;
    }

    public List<Department> readDepartments() throws SQLException {
        Connection connection = MYSQLConnection.getConnection();
        String sql = "SELECT id, name FROM department ";
        List<Department> departments = new ArrayList<>();
        ResultSet resultSet;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {

                Department department = fillDepartment(resultSet);
                departments.add(department);
            }
        }
        if (connection != null) {
            connection.close();
        }
        return departments;
    }

    public void createDepartment(Department department) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "INSERT into department ( name) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, department.getName());
        preparedStatement.executeUpdate();

        if (connection != null) {
            connection.close();
        }

    }

    public void updateDepartment(Department department) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "UPDATE department SET name = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, department.getName());
        preparedStatement.setInt(2, department.getId());
        preparedStatement.executeUpdate();

        if (connection != null) {
            connection.close();
        }
    }

    public void deleteDepartment(Integer id) throws SQLException {

        Connection connection = MYSQLConnection.getConnection();
        String sql = "DELETE FROM department WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

        if (connection != null) {
            connection.close();
        }
    }

    public boolean checkName(String name, Integer id) throws SQLException {
        Connection connection = MYSQLConnection.getConnection();

        String sql = "SELECT * FROM department WHERE name = ? ";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getInt("id") != id) {
                    return false;
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
        return true;
    }

    @Override
    public void createOrUpdateDepartment(Department department) throws SQLException {

        String sql;
        Integer id = department.getId();
        if (id == null) {
            sql = "INSERT into department ( name) VALUES (?)";
        } else {
            sql = "UPDATE department SET name = ? WHERE id = ?";
        }
        Connection connection = MYSQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (id == null) {
            preparedStatement.setString(1, department.getName());
        } else {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getId());
        }
        preparedStatement.executeUpdate();

        if (connection != null) {
            connection.close();
        }
    }

    private Department fillDepartment(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getInt("id"));
        department.setName(resultSet.getString("name"));
        return department;
    }
}
