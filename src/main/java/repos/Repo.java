package repos;

import java.sql.SQLException;
import java.util.List;

public interface Repo<E> {

    /**
     * @param e
     */
    public void save(E e) throws SQLException;


    /**
     * @return a list of objects
     */
    public List<E> getAll() throws SQLException;

    public void finalize() throws SQLException;
}
