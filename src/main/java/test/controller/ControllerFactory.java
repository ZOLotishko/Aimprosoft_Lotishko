package test.controller;

import test.controller.dep.AddDepartmnetsController;
import test.controller.dep.DeleteDepartmnetsController;
import test.controller.dep.ShowAddListController;
import test.controller.dep.ShowAllDepartmnetsController;
import test.controller.empl.AddEmployeeController;
import test.controller.empl.EmployeeControllerDelete;
import test.controller.empl.ShowEmployeeAddListController;
import test.controller.empl.ShowListEmployeeController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 04.04.16.
 */
public class ControllerFactory {

    private Map<String, InternalController> controllerMap = new HashMap<String, InternalController>();

    private InternalController defaultController = new ShowAllDepartmnetsController();


    {
        controllerMap.put("/", defaultController);
        controllerMap.put("/deleteDepartment", new DeleteDepartmnetsController());
        controllerMap.put("/showAddList", new AddDepartmnetsController());
        controllerMap.put("/addDepartments", new ShowAddListController());
        controllerMap.put("/listEmployee", new ShowListEmployeeController());
        controllerMap.put("/addEmployee", new ShowEmployeeAddListController());
        controllerMap.put("/addEmployees", new AddEmployeeController());
        controllerMap.put("/deleteEmployee", new EmployeeControllerDelete());

    }

    public InternalController getControllerByName(String name){
        return controllerMap.get(name);
    }

    public InternalController getDefaultController(){
        return defaultController;
    }

}
