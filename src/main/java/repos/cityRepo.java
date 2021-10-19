package repos;

import models.City;
import utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cityRepo implements Repo<City> {

    private Connection conn;

    public cityRepo(){
        conn = ConnectionManager.getConnection();
    }

    /**
     * @param city the object to be persisted to DB
     */
    @Override
    public void save(City city) throws SQLException{
        String sql = "SELECT * FROM cities WHERE code = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, city.getCode());

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            //if item exists
            String update = "UPDATE cities SET code = ?, city = ?, state =?";
            PreparedStatement updatestmt = conn.prepareStatement(update);
            updatestmt.setString(1, city.getCode());
            updatestmt.setString(2, city.getCity());
            updatestmt.setString(3, city.getState());

            System.out.println(updatestmt);

            updatestmt.executeUpdate();
        } else {
            String insert = "INSERT INTO cities (code, city, state)(?, ?, ?)";
            PreparedStatement updatestmt = conn.prepareStatement(insert);
            updatestmt.setString(1, city.getCode());
            updatestmt.setString(2, city.getCity());
            updatestmt.setString(3, city.getState());

            System.out.println(updatestmt);

            updatestmt.executeUpdate();
        }
    }

    /**
     * @param code String to specify desired object
     * @return returns City object specified by Code
     */
    public City getByCode(String code) throws SQLException {
        String sql = "SELECT * FROM cities WHERE code = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, code);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            return new City(rs.getString("code"), rs.getString("city"),
                    rs.getString("state"));
        } else {
            return null;
        }
    }

    /**
     * @return a list of objects
     */
    @Override
    public List<City> getAll() throws SQLException {
        String sql = "SELECT * FROM cities";
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        List<City> cityList = new ArrayList<>();

        while(rs.next()){
            City c = new City(rs.getString("code"), rs.getString("city"),
                    rs.getString("state"));
            cityList.add(c);
        }

        return cityList;
    }

    /**
     * Removes object from DB
     *
     * @param code 3 letters that represent the city code
     */
    public void deleteByCode(String code) throws SQLException{
        String sql = "DELETE FROM cities WHERE code = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, code);

        ps.executeUpdate();
    }

    public void finalize() throws SQLException{
        conn.close();
    }
}