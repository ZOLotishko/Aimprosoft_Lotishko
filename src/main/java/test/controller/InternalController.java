package test.controller;

import test.exeption.ErrorException;
import test.exeption.ValidationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 04.04.16.
 */
public interface InternalController {

    void executor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ValidationException, ErrorException;

}
