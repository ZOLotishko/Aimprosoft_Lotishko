package test.validation;


import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 08.04.16.
 */
public class MyValidation {


   private Validator validator = new Validator();

    public Map<String, String> validation(Object object){
        Map<String,String> error = new HashMap<>();
        if (object != 0 ) {
            List<ConstraintViolation> violations = validator.validate(object);
            if (violations.size() > 0) {
                for (ConstraintViolation constraintViolation : violations) {
                    OValContext context = constraintViolation.getContext();
                    if (context instanceof FieldContext) {
                        Field fieldContext = ((FieldContext) context).getField();
                        error.put(fieldContext.getName(), constraintViolation.getMessage());
                    }
                }
            }
        }

        return error ;
    }
}
