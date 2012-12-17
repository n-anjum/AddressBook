package net.therap.addressbook.dao;

import net.therap.addressbook.domain.User;
import net.therap.addressbook.utils.DatabaseTemplate;
import net.therap.addressbook.utils.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: sazzadur
 * @since: 10/3/12 1:26 PM
 */

public class UserDaoImpl implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    public void saveUser(User user) {
        log.debug("About to save user");
        DatabaseTemplate.executeInsertQuery("insert into USER(NAME,PASSWORD) values(?,?)", user.getName(), user.getPassword());
    }

    public User getUserByUserName(String userName) {
        List<User> userList = DatabaseTemplate.queryForObject("select * from USER where name = '" + userName + "'", new ObjectRowMapper<User>() {
            public User mapRowToObject(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });

        if(userList.size() != 0){
            return userList.get(0);
        }
        return null;
    }
}
