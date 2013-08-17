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

public class register extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>RegisterPage</title>\n");
    writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
    writer.write("</head>");
    writer.write("<body>");
    writer.write("<div id=\"header\" align = \"center\">");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>");
    writer.write("</div>");
    writer.write("<div id=\"socialNetworkBox\">");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>");
    writer.write("</div>");

    String username = request.getParameter("username");
    if((username == null) || (username.length() == 0))
    {
      printMsg("Please enter a username!", writer, request);
      return;
    }
    String password = request.getParameter("password");
    if((password == null) || (password.length() == 0))
    {
      printMsg("Please enter a password!", writer, request);
      return;
    }
    String firstname = request.getParameter("firstname");
    if((firstname == null) || (firstname.length() == 0))
    {
      printMsg("Please enter your firstname!", writer, request);
      return;
    }
    String lastname = request.getParameter("lastname");
    if((lastname == null) || (lastname.length() == 0))
    {
      printMsg("Please enter your lastname!", writer, request);
      return;
    }
    String confirmpassword = request.getParameter("confirmpassword");
    if((confirmpassword == null) || (confirmpassword.length() == 0))
    {
      printMsg("Confirm Password and Password not equal!", writer, request);
      return;
    }
    String email = request.getParameter("email");
    if((email == null) || (email.length() == 0))
    {
      printMsg("Please enter a email address!", writer, request);
      return;
    }
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
    }
    catch(ClassNotFoundException exc)
    {
      exc.printStackTrace();
      printMsg("no JDBC driver found!", writer, request);
      return;
    }

    try
    {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      String sql = "INSERT INTO user(FirstName, LastName, Email, username, password, admin) VALUES('" + firstname + "','" + lastname + "','" + email + "','" + username + "','"+ password +"', 0)";
      Statement statement = connection.createStatement();
      int row = statement.executeUpdate(sql);
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("database error!", writer, request);
    }

    try
    {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      Statement statement = connection.createStatement();
      ResultSet query = statement.executeQuery("SELECT id FROM user WHERE username = '"+ username +"'");
      String id = "";
      if(query.next())
          id = query.getString("id");
      String sql = "INSERT INTO profiles(UserID, Interest1_id, Interest1_rating, Interest2_id, Interest2_rating, Interest3_id, Interest3_rating, Activity1_id, Activity1_rating, Activity2_id, Activity2_rating, Activity3_id, Activity3_rating) VALUES("+ id +",'',0,'',0,'',0,'',0,'',0,'',0)";
      statement.executeUpdate(sql);
      printMsg("" + firstname + ", " + lastname + " successfully registered!", writer, request);
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("database error!", writer, request);
    }
  }

  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h1 style=\"clear: left;\">" + msg + "</h1>\n");
    writer.write("<hr/>\n");
    writer.write("<form action=\"logout\" method=\"GET\" style=\"float: left;\">\n");
    writer.write("<input style=\"margin-left: 0px\" type =\"submit\" value =\"login\"/>\n");
    writer.write("</form>\n");
    writer.write("<div id=\"footer\">\n");
    writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | \n");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>\n");
    writer.write("</p>\n");
    writer.write("</div>\n");
    writer.write("</body>\n");
    writer.write("</html>\n");
  }
}
