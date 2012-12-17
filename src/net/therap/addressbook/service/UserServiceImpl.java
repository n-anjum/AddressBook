package net.therap.addressbook.service;

import net.therap.addressbook.dao.UserDao;
import net.therap.addressbook.dao.UserDaoImpl;
import net.therap.addressbook.domain.User;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: sazzadur
 * @since: 10/3/12 3:23 PM
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public User verifyUser(User user) {
        User verifiedUser = userDao.getUserByUserName(user.getName());
        if(verifiedUser != null && verifiedUser.getPassword().equals(user.getPassword())) {
            return verifiedUser;
        }
        return null;
    }
}
