import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.hibernateManager;

public class Main {
    //TODO look into why everything is default autoincrement with the @id
    //TODO the relationships
    public static void main(String[] args){
        SessionFactory sFactory = hibernateManager.getSessionFactory();
        sFactory.close();
    }
}
