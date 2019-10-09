package app.DAO.interfaces;

import java.sql.SQLException;

public interface DAO<T> {


    void  update(Integer id) throws SQLException;
    void  delete(Integer id) throws SQLException;
    T select (Integer id) throws SQLException;

}
