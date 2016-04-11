package test.controller;

import test.exeption.ErrorException;
import test.exeption.ValidationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 04.04.16.
 */
public class MainController extends HttpServlet{

    private ControllerFactory controllerFactory = new ControllerFactory();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String controllerAction = req.getRequestURI();

        InternalController controller = controllerFactory.getControllerByName(controllerAction);
        if(controller==null){
            controller = controllerFactory.getDefaultController();
        }
        try {
            try {
                controller.executor(req, resp);
            } catch (ErrorException e) {
                e.printStackTrace();
            }
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}
