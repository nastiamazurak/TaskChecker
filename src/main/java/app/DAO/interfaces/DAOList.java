package app.DAO.interfaces;


import app.DAO.interfaces.DAO;
import app.entities.List;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOList extends DAO<List> {

    ArrayList<List> getByUserId(int userId) throws SQLException;




}
