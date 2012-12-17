package net.therap.addressbook.dao;

import net.therap.addressbook.domain.Contact;
import net.therap.addressbook.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 10/9/12
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ContactDao {
    public void saveContactIntoTable(Contact contact, User loggedInUser);
    public List<Contact> getAllContact(User loggedInUser);
    public Contact getContact(int contactId);
    void updateContact(Contact contact, User loggedInUser);
    void deleteContact(int contactId);
}
