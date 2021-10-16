package repos;

import models.User;

import java.util.List;

public class userRepo implements Repo<User> {
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
    @Override
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
    @Override
    public void deleteByID(int id) {

    }
}
