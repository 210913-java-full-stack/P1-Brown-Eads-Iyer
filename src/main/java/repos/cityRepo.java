package repos;

import models.City;

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