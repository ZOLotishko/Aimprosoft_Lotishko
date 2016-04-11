package test.controller;

import test.controller.dep.DepartmentsControllerAdd;
import test.controller.dep.DepartmentsControllerDelete;
import test.controller.dep.DepartmentsControllerShowAddList;
import test.controller.dep.DepartmentsControllerShowAll;
import test.controller.empl.EmployeeControllerAdd;
import test.controller.empl.EmployeeControllerDelete;
import test.controller.empl.EmployeeControllerShowAddList;
import test.controller.empl.EmployeeControllerShowList;

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

    }

    public InternalController getControllerByName(String name){
        return controllerMap.get(name);
    }

    public InternalController getDefaultController(){
        return defaultController;
    }

}
