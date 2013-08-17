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

public class getdestinations extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\"\n");
    writer.write("\"http://www.w3.org/TR/RBC-html40/loose.dtd\">\n");
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>getdestinations</title>\n");
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"main.css\" />\n");
    writer.write("</head>\n");
    writer.write("<body>\n");
    writer.write("<div id=\"header\">\n");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\" />\n");
    writer.write("</div>\n");
    writer.write("<div id=\"socialNetworkBox\">\n");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>\n");
    writer.write("</div>\n");
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 950px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");

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
    writer.write("<p style=\"font-size: 20; margin-left: 110px;\">Destinations sorted by your activities and interests:</p>\n");


    try
    {
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          int user_id = 1;
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
          Statement statement = connection.createStatement();
          ResultSet query_result = statement.executeQuery("SELECT destination.name FROM destination, destinationprofiles WHERE destination.id = destinationprofiles.destination_id ORDER BY ABS(ABS(destinationprofiles.interest1_id_rating + destinationprofiles.interest2_id_rating + destinationprofiles.interest3_id_rating)-(SELECT SUM(profiles.Interest1_id + profiles.Interest2_id + profiles.Interest3_id) FROM user, profiles WHERE profiles.UserID = user.id AND user.Id = "+user_id+")) ASC LIMIT 0,5");
          while(query_result.next())
          {
            String destination = query_result.getString("name");

            writer.write("<fieldset style=\"width:350px; height:70px; margin-left: 350px; background-image:url(output.png);\">");
            writer.write("<h2 align = \"center\">"+destination+"</h2>");
            writer.write("</fieldset>");
            writer.write("<br>");
            writer.write("<br>");
          }
      }
      else
      {
        response.sendRedirect(""+"index.html");
      }
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("database error!", writer, request);
    }
    writer.write("<form action=\"getrecommendationpage\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 100px\"type =\"submit\" value =\"Back\"/>\n");
    writer.write("</form>\n");
    printMsg("", writer, request);
  }

  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h1 style=\"clear: left;\">" + msg + "</h1>\n");
    writer.write("<hr/>\n");
    writer.write("<div id=\"footer\">\n");
    writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | \n");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>\n");
    writer.write("</p>\n");
    writer.write("</div>\n");
    writer.write("</body>\n");
    writer.write("</html>\n");

  }
}
