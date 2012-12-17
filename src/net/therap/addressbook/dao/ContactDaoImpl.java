package net.therap.addressbook.dao;

import net.therap.addressbook.domain.Contact;
import net.therap.addressbook.domain.User;
import net.therap.addressbook.utils.DatabaseTemplate;
import net.therap.addressbook.utils.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anjum
 * Date: 10/9/12
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class ContactDaoImpl implements ContactDao {
    private static final Logger log = LoggerFactory.getLogger(ContactDaoImpl.class);
    public void saveContactIntoTable(Contact contact, User loggedInUser) {
        log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+loggedInUser.getId());
        log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+loggedInUser.getName());
        log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+loggedInUser.getPassword());
        log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+contact.getName());
        log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+contact.getAddress());
        log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+contact.getEmail());
        log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+contact.getPhoneNo());
        DatabaseTemplate.executeInsertQuery("insert into ContactTable(USER_ID,CONTACT_NAME,CONTACT_ADDRESS,CONTACT_PHONE_NO,CONTACT_EMAIL) values(?,?,?,?,?)", loggedInUser.getId(),
                contact.getName(), contact.getAddress(), contact.getPhoneNo(), contact.getEmail());
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Contact> getAllContact(User loggedInUser) {
        List<Contact> contactList = DatabaseTemplate.queryForObject("select * from ContactTable where USER_ID= " + loggedInUser.getId(), new ObjectRowMapper<Contact>() {
            public Contact mapRowToObject(ResultSet resultSet) throws SQLException {
                Contact contact = new Contact();
                contact.setName(resultSet.getString("contact_name"));
                contact.setAddress(resultSet.getString("contact_address"));
                contact.setEmail(resultSet.getString("contact_email"));
                contact.setPhoneNo(resultSet.getString("contact_phone_no"));
                contact.setId(resultSet.getInt("contact_id"));
                return contact;
            }
        });
        if (contactList.size() != 0) {
            return contactList;
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Contact getContact(int contactId) {
        List<Contact> contactList = DatabaseTemplate.queryForObject("select * from ContactTable where CONTACT_ID= " + contactId, new ObjectRowMapper<Contact>() {
            public Contact mapRowToObject(ResultSet resultSet) throws SQLException {
                Contact contact = new Contact();
                contact.setName(resultSet.getString("contact_name"));
                contact.setAddress(resultSet.getString("contact_address"));
                contact.setEmail(resultSet.getString("contact_email"));
                contact.setPhoneNo(resultSet.getString("contact_phone_no"));
                contact.setId(resultSet.getInt("contact_id"));
                return contact;
            }
        });
        if (contactList.size() != 0) {
            return contactList.get(0);
        }
        return null;

    }

    public void updateContact(Contact contact, User loggedInUser) {
        String sql = "UPDATE ContactTable SET CONTACT_NAME= '"+contact.getName()+"' , CONTACT_ADDRESS= '"+contact.getAddress() +"' , " +
                "CONTACT_PHONE_NO= '"+contact.getPhoneNo()+"' , CONTACT_EMAIL= '"+contact.getEmail()+"'  WHERE Contact_id= " + contact.getId();
        log.debug(sql);
        DatabaseTemplate.executeUpdate(sql);

    }

    public void deleteContact(int contactId) {
        String sql = "DELETE FROM ContactTable WHERE Contact_id= " + contactId;
        log.debug(sql);
        DatabaseTemplate.executeUpdate(sql);

        //To change body of implemented methods use File | Settings | File Templates.
    }
}
