package repos;

import java.util.List;
import models.Booking;

public class bookingRepo implements Repo<Booking>{
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
    @Override
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
    @Override
    public void deleteByID(int id) {

    }
}
