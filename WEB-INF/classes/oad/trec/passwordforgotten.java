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

public class passwordforgotten extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>PasswordForgottenPage</title>\n");
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"main.css\" />\n");
    writer.write("</head>\n");
    writer.write("<body>\n");
    writer.write("<div id=\"header\" align = \"center\">\n");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\" />\n");
    writer.write("</div>\n");
    writer.write("<div id=\"socialNetworkBox\">\n");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>\n");
    writer.write("</div>\n");

    String username = request.getParameter("username");
    if((username == null) || (username.length() == 0))
    {
      printMsg("No user found!", writer, request);
      return;
    }
    String email = request.getParameter("email");
    if((email == null) || (email.length() == 0))
    {
      printMsg("No email entered!", writer, request);
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
    String password_db = null;
    String username_db = null;
    try
    {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      Statement statement = connection.createStatement();
      ResultSet query_result = statement.executeQuery("SELECT username, password FROM user WHERE username = '" + username + "'");

      if(query_result.next())
      {
        username_db = query_result.getString("username");
        password_db = query_result.getString("password");
  
        writer.write("<div id =\"evaluate\">\n");
        writer.write("<fieldset style=\"width: 880px\">\n");
        writer.write("<legend>Password forgotten</legend>\n");
        writer.write("<form action=\"logout\" method=\"GET\">\n");
        writer.write("<p>Your password has been send to your email account!</p>\n");
        writer.write("<p>username: "+username+"</p>\n");
        writer.write("<p>email: "+email+"</p>\n");
        writer.write("<table><tr>\n");
        writer.write("<td><input type =\"submit\" value =\"login\"/></td>\n");
        writer.write("</form>\n");
        writer.write("<form action=\"logout\" method=\"GET\">\n");
        writer.write("<td><input style=\"margin-left:50px\" type =\"submit\" value =\"Cancel\"/></td>\n");
        writer.write("</tr></table>\n");
        writer.write("</form>\n");
        writer.write("<br><br><br>\n");
        writer.write("</fieldset>\n");
        writer.write("</div>\n");
        printMsg("", writer, request);
      }
      else
      {
          printMsg("error", writer, request);
          return;
        }
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("Cannot find user: database error!", writer, request);
    }
 }


  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h1>" + msg + "</h1>\n");
    writer.write("<hr/>\n");
    writer.write("<div id=\"footer\">\n");
    writer.write("<p align = \"center\"> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | \n");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>\n");
    writer.write("</p>\n");
    writer.write("</div>\n");
    writer.write("</body>\n");
    writer.write("</html>\n");
  }
}
