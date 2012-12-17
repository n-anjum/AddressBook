package net.therap.addressbook.domain;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 10/9/12
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Contact {
    private String name;
    private String address;
    private String email;
    private String phoneNo;
    private int id;

    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhoneNo(){
        return this.phoneNo;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }
    public int getId(){
        return this.id;

    }
    public void setId(int id){
        this.id = id;

    }


}
