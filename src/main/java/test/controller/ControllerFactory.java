package test.controller;

import test.controller.department.DepartmentsControllerAdd;
import test.controller.department.DepartmentsControllerDelete;
import test.controller.department.DepartmentsControllerShowAddList;
import test.controller.department.DepartmentsControllerShowAll;
import test.controller.employee.EmployeeControllerAdd;
import test.controller.employee.EmployeeControllerDelete;
import test.controller.employee.EmployeeControllerShowAddList;
import test.controller.employee.EmployeeControllerShowList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 04.04.16.
 */
public class ControllerFactory {

    private Map<String, InternalController> controllerMap = new HashMap<String, InternalController>();

    private InternalController defaultController = new DepartmentsControllerShowAll();


    {
        controllerMap.put("/", defaultController);
        controllerMap.put("/deleteDepartment", new DepartmentsControllerDelete());
        controllerMap.put("/showAddList", new DepartmentsControllerAdd());
        controllerMap.put("/addDepartment", new DepartmentsControllerShowAddList());
        controllerMap.put("/listEmployees", new EmployeeControllerShowList());
        controllerMap.put("/addEmployee", new EmployeeControllerShowAddList());
        controllerMap.put("/addEmployees", new EmployeeControllerAdd());
        controllerMap.put("/deleteEmployee", new EmployeeControllerDelete());
        controllerMap.put("/error",new ErrorController());
    }

    public InternalController getControllerByName(String name) {
        return controllerMap.get(name);
    }

    public InternalController getDefaultController() {
        return defaultController;
    }

}
