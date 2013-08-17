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

public class login extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>Error</title>\n");
    writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
    writer.write("</head>\n");
    writer.write("<body>\n");
    writer.write("<div id=\"header\" align = \"center\">\n");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>\n");
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
    String password = request.getParameter("password");
    if((password == null) || (password.length() == 0))
    {
      printMsg("No password entered!", writer, request);
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
    String admin = null;
    String sql = null;
    try
    {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      Statement statement = connection.createStatement();
      ResultSet query_result = statement.executeQuery("SELECT admin FROM user WHERE username = '" + username + "' AND password = '"+ password + "'");
      HttpSession sess = request.getSession(true);
      user tmpuser;

      if(query_result.next())
      {
        admin = query_result.getString("admin");
        query_result = statement.executeQuery("SELECT id, username FROM activeuser");
        if(query_result.next())
        {
            sql = "DELETE FROM activeuser WHERE id = '"+ sess.getId() +"'";
            statement.executeUpdate(sql);
        }
        sql = "INSERT INTO activeuser VALUES ('"+sess.getId()+"', '"+username+"')";
        statement.executeUpdate(sql);
        tmpuser = new user();
        sess.putValue("user", tmpuser);
        query_result = statement.executeQuery("SELECT id FROM user WHERE username = '"+ username +"'");
        if(query_result.next())
        {
            ((user)sess.getValue("user")).setAccName(username);
            ((user)sess.getValue("user")).setAccNum(query_result.getString("id"));
            ((user)sess.getValue("user")).setAdmin(admin);
        }

        response.sendRedirect(""+"mainpage");     
      }
      else
      {
        printMsg("Username or password false!", writer, request);
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
    writer.write("<h1 style=\"clear: left;\">" + msg + "</h1>\n");
    writer.write("<br/>\n");
    writer.write("<div id = \"evaluate\"><form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 0px;\" type =\"submit\" value =\"Back\"/></div>\n");
    writer.write("<div id=\"footer\">\n");
    writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | \n");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>\n");
    writer.write("</p>\n");
    writer.write("</div>\n");
    writer.write("</body>\n");
    writer.write("</html>\n");
  }
}
