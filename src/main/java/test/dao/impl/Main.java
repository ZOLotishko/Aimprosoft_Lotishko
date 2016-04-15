package test.dao.impl;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.dao.DepartmentDAO;
import test.entity.Department;

/**
 * Created on 14.04.16.
 */
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DepartmentDAO departmentDAO = (DepartmentDAO) context.getBean("departmentDAO");
        Department department = new Department(100, "name");
//        departmentDAO.createDepartment(department);

//        Department department1 = departmentDAO.readDepartments();
        System.out.println(departmentDAO.readDepartments());
        context.close();
    }
}
