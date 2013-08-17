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

public class getcustomers extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\"\n");
    writer.write("\"http://www.w3.org/TR/RBC-html40/loose.dtd\">\n");
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>Get Customers</title>\n");
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
    writer.write("<p style=\"font-size: 20; margin-left: 110px;\">Customers:</p>\n");


    try
    {
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          String hotel_name = request.getParameter("hotel");
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
          Statement statement = connection.createStatement();
          ResultSet query_result = statement.executeQuery("SELECT user.ID, user.FirstName, user.LastName, user.Email, user.username FROM user, hotel, citys, destination, hotelprofiles WHERE hotelprofiles.hotel_id = hotel.id AND hotel.name = '"+hotel_name+"' GROUP BY user.Id ORDER BY ABS(ABS(hotelprofiles.activity1_id_rating + hotelprofiles.activity2_id_rating + hotelprofiles.activity3_id_rating)-(SELECT SUM(profiles.Activity1_id + profiles.Activity2_id + profiles.Activity3_id) FROM user, profiles WHERE profiles.UserID = user.id AND user.Id = 1)) ASC LIMIT 0,5");
          while(query_result.next())
          {
            int user_id = Integer.parseInt(query_result.getString("user.Id"));
            String firstname = query_result.getString("user.FirstName");
            String lastname = query_result.getString("user.LastName");
            String email = query_result.getString("user.Email");
            String username = query_result.getString("user.username");
            writer.write("<fieldset style=\"width:500px; height:60px; margin-left: 200px; background-image:url(output.png);\">");
            writer.write("<table style=\"margin-top:10px; margin-left:10px;\">\n");
            writer.write("<tr><td style=\"width: 350px\">\n");
            writer.write("<tr><td><p style=\"font-size:17; font:calibri;\">user_id: <i>"+ user_id +"</i> |  firstname: <i>"+ firstname +"</i>  |  lastname: <i>"+ lastname +"</i> | email: <i>"+ email +"</i>  | username: <i>"+ username +"</i></p></td>\n");
            writer.write("</tr></table>\n");
            writer.write("</fieldset>");
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
    writer.write("<form action=\"admingetrecommendationpage\" method=\"GET\">\n");
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
