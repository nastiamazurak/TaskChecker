package app.DAO;
import app.DAO.interfaces.DAO;
import app.DAO.interfaces.DAOList;
import app.entities.List;

import app.jdbc.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ListDAO implements DAOList {

    private Connection connection = DBConnection.getConnection(); ;

    @Override
    public ArrayList<List> getByUserId(int userId) throws SQLException{
        String sql = "SELECT * FROM ToDoList where userId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,userId );

        ResultSet result = statement.executeQuery();

        ArrayList<List> lists = new ArrayList<>();
        while (result.next()) {

            List list = new List();
            list.setId(result.getInt("id"));
            list.setContent(result.getString("Content"));
            list.setAddDate(result.getDate("addDate").toLocalDate());
            list.setDone(result.getInt("Done"));
            list.setUserId(userId);
            lists.add(list);
        }
        result.close();

        return lists;

    }

    public ArrayList<List> showDone(Integer userId) throws SQLException {

        String sql = "SELECT * from ToDoList WHERE Done = 1 WHERE UserId = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,userId );

        ResultSet result = statement.executeQuery();

        ArrayList<List> lists = new ArrayList<>();
        List list = new List();
        while (result.next()){
            list.setId(result.getInt("id"));
            list.setContent(result.getString("Content"));
            list.setAddDate(result.getDate("addDate").toLocalDate());
            list.setDone(result.getInt("Done"));
            list.setUserId(userId);
            lists.add(list);
        }
        result.close();

        return lists;

    }

    public ArrayList<List> showUndone(Integer userId) throws SQLException {

        String sql = "SELECT * from ToDoList WHERE Done = 0 AND UserId = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,userId );

        ResultSet result = statement.executeQuery();

        ArrayList<List> lists = new ArrayList<>();
        List list = new List();
        while (result.next()){
            list.setId(result.getInt("id"));
            list.setContent(result.getString("Content"));
            list.setAddDate(result.getDate("addDate").toLocalDate());
            list.setDone(result.getInt("Done"));
            list.setUserId(userId);
            lists.add(list);
        }
        result.close();

        return lists;

    }



    public void insert(Integer userId, String content) throws SQLException {

        String sql = "INSERT into ToDoList (content, UserId ) Values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, content);
        statement.setInt(2, userId);


        statement.execute();
        statement.close();
    }


    public int GetStatus(Integer id) throws SQLException{
        String sql = "Select Done from ToDoList WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        int status = 0;
        if (result.next()){
            status = result.getInt("Done");



        }
        return status;
    }

    @Override
    public void update(Integer id) throws SQLException {
        String sql = "UPDATE TodoList Set Done = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        int done = GetStatus(id);
        statement.setInt(1, done);
        statement.setInt(2, id);

        statement.execute();
        statement.close();
    }

    public void update(Integer id, String content) throws SQLException {


        String sql = "UPDATE ToDoList SET content = ?  WHERE id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, content);
        statement.setInt(2, id);

        statement.execute();
        statement.close();


    }

    @Override
    public void delete(Integer id) throws SQLException {

        String sql = "DELETE FROM TodoList WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
        statement.close();

    }

    @Override
    public List select(Integer id) throws SQLException {
        String sql = "SELECT * FROM ToDoList WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        List list = new List();
        if (result.next()){
            list.setId(id);
            list.setUserId(result.getInt("UserId"));
            list.setContent(result.getString("Content"));
            list.setAddDate(result.getDate("addDate").toLocalDate());


        }
        return null;
    }
}

