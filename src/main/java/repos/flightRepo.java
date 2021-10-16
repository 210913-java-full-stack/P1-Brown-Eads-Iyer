package repos;

import models.Flight;

import java.util.List;

public class flightRepo implements Repo<Flight> {
    /**
     * @param flight
     */
    @Override
    public void save(Flight flight) {

    }

    /**
     * @param id int to specify desired object
     * @return
     */
    @Override
    public Flight getByID(int id) {
        return null;
    }

    /**
     * @return a list of objects
     */
    @Override
    public List<Flight> getAll() {
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
