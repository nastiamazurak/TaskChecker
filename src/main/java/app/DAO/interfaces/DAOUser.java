package app.DAO.interfaces;

import app.DAO.interfaces.DAO;
import app.entities.User;

import java.sql.SQLException;

public interface DAOUser extends DAO<User> {

    User getByEmail(String email, String password) throws SQLException;

 //накидати ше якісь методики



}
