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

public class Activities
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
  public void changeActivities(HttpServletRequest request, PrintWriter writer)
  {
    HttpSession sess = request.getSession(true);
    if(sess.getValue("user") != null)
    {
        String id = ((user)sess.getValue("user")).getAccNum();

        updateRating(valueOne_, id, "Activity1_rating");
        updateId(idOne_, id, "Activity1_id");
        updateRating(valueTwo_, id, "Activity2_rating");
        updateId(idTwo_, id, "Activity2_id");
        updateRating(valueThree_, id, "Activity3_rating");
        updateId(idThree_, id, "Activity3_id");
    }
  }
  public boolean updateId(String value, String id, String type)
  {
     try
     {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
        String sql = "UPDATE profiles SET " + type +  "= '" + value+"' WHERE userid = " + id + "";
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
