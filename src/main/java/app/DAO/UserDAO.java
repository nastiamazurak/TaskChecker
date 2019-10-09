package app.DAO;
import app.DAO.interfaces.DAOUser;
import app.entities.User;
import app.jdbc.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements DAOUser {

    private Connection connection = DBConnection.getConnection();



    public void insert(String email, String password) throws SQLException {

        String sql = "INSERT into users (email, password ) Values ( ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, email);
        statement.setString(2, password);
        statement.execute();
        statement.close();



    }

    @Override
    public void update(Integer id) throws SQLException {




    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
        statement.close();

    }

    @Override
    public User select(Integer id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet  result = statement.executeQuery();

        User user = new User();
        if (result.next()){
            user.setId(result.getInt("id"));
            user.setEmail(result.getString("email"));
            user.setPassword(result.getString("password"));
        }

        result.close();
        statement.close();


        return user;
    }


    @Override
    public User getByEmail(String email, String password) throws SQLException {

        String sql = "SELECT *  FROM users WHERE Email = ? and Password = ?  ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setId(result.getInt("Id"));
        }

        result.close();
        statement.close();

        return user;
    }


}







