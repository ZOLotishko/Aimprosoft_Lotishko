package test.controller;

import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 13.04.16.
 */
@Component("/error")
public class ErrorController implements InternalController {
    @Override
    public void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
}
