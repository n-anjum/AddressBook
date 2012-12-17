package net.therap.addressbook.dao;

import net.therap.addressbook.domain.User;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: sazzadur
 * @since: 10/3/12 1:21 PM
 */
public interface UserDao {

    public void saveUser(User user);

    public User getUserByUserName(String userName);
}
