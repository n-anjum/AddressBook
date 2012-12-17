package net.therap.addressbook.service;

import net.therap.addressbook.annotations.NonEmptyField;
import net.therap.addressbook.domain.User;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 10/11/12
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidationServiceImpl implements ValidationService {

    List<String> invalidFields;
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ValidationServiceImpl.class);

    public ValidationServiceImpl() {
        invalidFields = new ArrayList<String>();

    }


    public boolean validateFormFields(Object object) throws IllegalAccessException {
        boolean validate = true;
        if (object instanceof User) {
            User user = (User) object;
            Class userClass = User.class;
            Field fields[] = userClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals("userId"))
                    continue;
                if (field.getName().equals("userName") || field.getName().equals("password")) {
                    Annotation annotation = field.getAnnotation(NonEmptyField.class);
                    if (annotation != null) {
                        if (user.getName().equals("") || user.getPassword().equals("")) {
                            invalidFields.add(field.getName().toUpperCase());
                            validate = false;

                        }
                    }

                }
            }


        }

        log.debug("field " + invalidFields);
        return validate;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<String> invalidateForms() {
        return invalidFields;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String buidNotifications(List<String> strings) {
        log.debug("This is the String " + strings);
        String finalMessage = "";
        for (String str : strings) {
            finalMessage += str + " ";
        }
        log.debug("This is the String " + strings);
        return finalMessage;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
