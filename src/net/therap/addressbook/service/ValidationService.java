package net.therap.addressbook.service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 10/11/12
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ValidationService {
    boolean validateFormFields(Object object) throws IllegalAccessException;
    List<String> invalidateForms();
    String buidNotifications(List<String> strings);
}
