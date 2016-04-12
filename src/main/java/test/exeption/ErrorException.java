package test.exeption;

import java.sql.SQLException;

/**
 * Created by Sveta on 10.04.2016.
 */
public class ErrorException extends Exception {

    public ErrorException(String message) {
        super(message);
    }
}
