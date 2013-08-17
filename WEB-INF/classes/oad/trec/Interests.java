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

public class Interests
{
  String idOne_;
  String idTwo_;
  String idThree_;
  String valueOne_;
  String valueTwo_;
  String valueThree_;


  public void setProfile(String idone, String idtwo, String idthree, String valueone, String valuetwo, String valuethree)
  {
    idOne_ = idone;
    idTwo_ = idtwo;
    idThree_ = idthree;
    valueOne_ = valueone;
    valueTwo_ = valuetwo;
    valueThree_ = valuethree;
  }
  public void changeInterests(HttpServletRequest request, PrintWriter writer)
  {
    HttpSession sess = request.getSession(true);
    if(sess.getValue("user") != null)
    {
        String id = ((user)sess.getValue("user")).getAccNum();
        
        updateRating(valueOne_, id, "Interest1_rating");
        updateId(idOne_, id, "Interest1_id");
        updateRating(valueTwo_, id, "Interest2_rating");
        updateId(idTwo_, id, "Interest2_id");
        updateRating(valueThree_, id, "Interest3_rating");
        updateId(idThree_, id, "Interest3_id");
    }
  }
  public boolean updateId(String value, String id, String type)
  {
     try
     {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
        String sql = "UPDATE profiles SET " + type +  "= '" + value+"' WHERE userid = " + id;
        Statement statement = connection.createStatement();
        String test = "SELECT id FROM profiles WHERE userid = "+ id;
        if(test.isEmpty() || test == null || test.equals(""))
        {
            sql = "INSERT INTO profiles (userid, "+ type +") Values ("+ id +", "+ value +")";
        }
        statement.executeUpdate(sql);
        return true;
    }
    catch(SQLException exc)
    {
        exc.printStackTrace();
        return false;
    }
  }
  public boolean updateRating(String value, String id, String type)
  {
     try
     {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
        String sql = "UPDATE profiles SET " + type +  "= '" + value + "' WHERE userid = " + id + "";
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
