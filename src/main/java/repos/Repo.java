package repos;

import java.util.List;

public interface Repo<E> {

    /**
     * @param e
     */
    public void save(E e);

    /**
     * @param id int to specify desired object
     * @return
     */
    public E getByID(int id);

    /**
     * @return a list of objects
     */
    public List<E> getAll();

    /**
     * Removes object from DB
     * @param id
     */
    public void deleteByID(int id);
}
