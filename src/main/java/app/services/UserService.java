package app.services;

import app.DAO.UserDAO;
import app.entities.User;
import app.exceptions.PasswordException;
import app.exceptions.UserRegisteredException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UserService {


    public static String encodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public User RegisterUser(String email, String password, String confirm) throws SQLException, UserRegisteredException, PasswordException {

        UserDAO userDao = new UserDAO();
        User user = null;

        if (password.equals(confirm)) {

            if (userDao.getByEmail(email, password) == null) {
                userDao.insert(email, password);
                user = userDao.getByEmail(email, password);
            }

            else {

                throw new UserRegisteredException();
            }

        }
         else {
              throw new PasswordException();
            }

         return user;


    };


    // опрацювати тут ексепшини
    public User loginUser(String email, String password){

        UserDAO userDao = new UserDAO();
        User user = null;

        try{
            user = userDao.getByEmail(email, password);

        } catch (SQLException e){
            e.printStackTrace();
        }

       return user;
    }





}
