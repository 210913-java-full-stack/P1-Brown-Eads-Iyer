package repos;

import models.Flight;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class flightRepo implements Repo<Flight> {

    Connection conn;

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
    public void deleteByID(int id) {

    }

    @Override
    public void finalize() throws SQLException {
        conn.close();
    }
}
