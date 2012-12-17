package net.therap.addressbook.service;

import net.therap.addressbook.dao.ContactDao;
import net.therap.addressbook.dao.ContactDaoImpl;
import net.therap.addressbook.domain.Contact;
import net.therap.addressbook.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 10/9/12
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class ContactListServiceImpl implements ContactListService{
    public ContactDao contactDao;
    Contact contactClass;
    public ContactListServiceImpl(){
        contactDao = new ContactDaoImpl();
    }
    public void saveContact(Contact contactClass, User user) {
        contactDao.saveContactIntoTable(contactClass,user);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Contact> getAllContact(User loggedInUser) {
        List<Contact> contacts = contactDao.getAllContact(loggedInUser);
        return contacts;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Contact getContact(int contactId) {
        Contact contact = contactDao.getContact(contactId);
        if(contact!=null)
            return  contact;
        return null;
    }

    public void updateContact(Contact contact, User loggedInUser) {
        contactDao.updateContact(contact,loggedInUser);
    }

    public void deleteContact(int contactId) {
        contactDao.deleteContact(contactId);
    }
}
