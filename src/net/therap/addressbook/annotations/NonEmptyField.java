package net.therap.addressbook.annotations;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 10/11/12
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface NonEmptyField {

}
