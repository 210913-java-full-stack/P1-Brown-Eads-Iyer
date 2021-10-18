package repos;

import models.City;

import java.sql.PreparedStatement;
import java.util.List;

public class cityRepo implements Repo<City> {
    /**
     * @param city
     */
    @Override
    public void save(City city) {

    }

    /**
     * @param id int to specify desired object
     * @return
     */
    @Override
    public City getByID(int id) {
        String sql = "SELECT * FROM cities WHERE id = ?";
        PreparedStatement ps = conn.pr

        return null;
    }

    /**
     * @return a list of objects
     */
    @Override
    public List<City> getAll() {
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