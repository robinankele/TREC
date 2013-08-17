package oad.trec;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MainData
{ 
  String last_name_;
  String first_name_;
  String email_;
  String password_new_;
  String password_new2_;
  String password_old_;


  public void setProfile(String last_name, String first_name,
   String email, String password_new, String password_new2, String password_old)
  {
    last_name_ = last_name;
    first_name_ = first_name;
    email_ = email;
    password_new_ = password_new;
    password_new2_ = password_new2;
    password_old_ = password_old;
  }
  public boolean dataChanges()
  {
    if((last_name_ != "") || (first_name_
       != "") || (email_ != "") || (password_new_ != ""))
      return true;
    else
       return false;
  }
  public boolean passwordCheck()
  {
    if(password_new_ == password_new2_)
      return true;
    else
      return false;
  }
  public boolean oldPasswordCheck(String actual_password)
  {
    if(actual_password.equals(password_old_))
      return true;
    else
      return false;
  }
  public boolean changeMainData(String password, HttpServletRequest request,
                                 PrintWriter writer)
  {
    HttpSession sess = request.getSession(true);
    if(sess.getValue("user") != null)
    {
        String id = ((user)sess.getValue("user")).getAccNum();
        if(!(first_name_.equals("")))
            update(id, first_name_, "FirstName");
        if(!(last_name_.equals("")))
            update(id, last_name_, "LastName");
        if(!(email_.equals("")))
            update(id, email_, "Email");
        if(!(password_new_.equals("")) && password.equals(password_old_) &&
             password_new_.equals(password_new2_))
            update(id, password_new_, "password");
    }
    else
    {
        return false;
    }
    return true;
  }
  public boolean update(String id, String new_text, String type)
  {
     try
     {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
        String sql = "UPDATE user SET " + type +  "= '" + new_text + "' WHERE id = \"" + id + "\"";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        return true;
    }
    catch(SQLException exc)
    {
        exc.printStackTrace();
        return false;
    }
  }

}
