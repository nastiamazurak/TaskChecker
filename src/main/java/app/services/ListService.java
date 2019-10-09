package app.services;
import app.DAO.ListDAO;
import app.entities.List;
import app.entities.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class ListService {

   public static ListDAO listDao = null;

    public static ArrayList<List> ShowLists (User user) throws SQLException  {

        ArrayList<List> todoLists = null;
        listDao = new ListDAO();
        todoLists = listDao.getByUserId(user.getId());

        return todoLists;

    }

    public static void AddList(Integer userId, String content) throws SQLException {


        List list = new List();
        listDao =  new ListDAO();
        listDao.insert(userId, content);

    }

    public static void DeleteList(Integer id) throws SQLException {

        listDao = new ListDAO();
        listDao.delete(id);
    }

    public static void updateList(Integer id, String content) throws SQLException {


        listDao = new ListDAO();
        listDao.update(id, content);

    }

    public static void updateDone(Integer id) throws SQLException{
        listDao = new ListDAO();
        listDao.update(id);
    }

    public static ArrayList<List>  filterItems(Integer filterId, Integer id) throws SQLException {
        listDao = new ListDAO();

        ArrayList<List> todoList =  null;

        switch (filterId) {
            case 1:
                todoList = listDao.getByUserId(id);
                break;
            case 2:
                todoList = listDao.showDone(id);
                break;
            case 3:
                todoList = listDao.showUndone(id);
                break;
        }
        return todoList;
    }
}
