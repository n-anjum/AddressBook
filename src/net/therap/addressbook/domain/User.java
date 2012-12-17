package net.therap.addressbook.domain;

import net.therap.addressbook.annotations.NonEmptyField;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 11/13/12
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    @NonEmptyField
    private String name;
    @NonEmptyField
    private String password;
    private int id;
    public void setName(String name){
        this.name=name;
    }
    public  void setPassword(String password){
        this.password = password;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return  this.password;
    }
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
