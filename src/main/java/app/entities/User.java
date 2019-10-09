package app.entities;

import java.util.Objects;

public class User {

    private Integer id;
    private String email;
    private String password;


    public User(Integer id, String email, String password){

        this.id = id;
        this.email = email;
        this.password = password;


    }
    public User (){

    }

    public int getId(){return id;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}


    public void setId(Integer id){this.id = id;}
    public void setEmail(String email){this.email=email;}
    public void setPassword(String password){this.password = password;}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id)  &&
                email.equals(user.email) &&
                password.equals(user.password);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
