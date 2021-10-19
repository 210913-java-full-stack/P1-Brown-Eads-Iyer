package repos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import models.Booking;

public class bookingRepo implements Repo<Booking>{
    Connection conn;

    /**
     * @param b
     */
    @Override
    public void save(Booking b) {

    }

    /**
     * @param id int to specify desired object
     * @return
     */
    public Booking getByID(int id) {
        return null;
    }

    /**
     * @return a list of objects
     */
    @Override
    public List<Booking> getAll() {
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
