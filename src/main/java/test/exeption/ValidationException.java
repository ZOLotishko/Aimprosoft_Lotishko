package test.exeption;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 08.04.16.
 */
public class ValidationException extends Exception {

    private Map<String, String> error = new HashMap<>();

    public ValidationException(Map<String, String> error){
        this.error = error;
    }

    public Map<String, String > getError(){
        return error;
    }

}
