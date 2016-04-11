package test;


import test.dao.EmployeeDAO;
import test.dao.impl.EmployeeDAOImpl;
import test.entity.Employee;
import test.exeption.ErrorException;
import test.util.Utils;

import java.util.Date;

/**
 * Created by user on 04.04.16.
 */
public class Main {
    public static void main(String[] args ) throws ErrorException {
        Date date = Utils.parseStringToDate("1222/12/12");
        Employee employee = new Employee("name","rfrfznj", date,76.9, 2);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        try {
            employeeDAO.createEmployee(employee);
        } catch (ErrorException e) {
            e.printStackTrace();
        }

        System.out.println(employeeDAO.readEmployees());

    }
}
