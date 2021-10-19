package repos;

import models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class userRepo implements Repo<User> {

    Connection conn;

    /**
     * @param user
     */
    @Override
    public void save(User user) {

    }

    /**
     * @param id int to specify desired object
     * @return
     */
    public User getByID(int id) {
        return null;
    }

    /**
     * @return a list of objects
     */
    @Override
    public List<User> getAll() {
        return null;
    }

    /**
     * Removes object from DB
     *
     * @param id
     */
    public void deleteByID(int id) {

    }

    @Override
    public void finalize() throws SQLException {
        conn.close();
    }
}
