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

public class booking extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>Booking Page</title>\n");
    writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
    writer.write("</head>");
    writer.write("<body>\n");
    writer.write("<div id=\"header\" align = \"center\">\n");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>\n");
    writer.write("</div>\n");
    writer.write("<div id = \"booking\">\n");

    String hotel = request.getParameter("hotel");
    if((hotel == null) || (hotel.length() == 0))
    {
      printMsg("Please enter a hotel!", writer, request);
      return;
    }
    String destination = request.getParameter("destination");
    if((destination == null) || (destination.length() == 0))
    {
      printMsg("Please enter a destination!", writer, request);
      return;
    }
    String persons = request.getParameter("persons");
    if((persons == null) || (persons.length() == 0))
    {
      printMsg("Please enter how many persons will be coming!", writer, request);
      return;
    }
    String nights = request.getParameter("nights");
    if((nights == null) || (nights.length() == 0))
    {
      printMsg("Please enter how many nights you want to stay!", writer, request);
      return;
    }
    String roomtype = request.getParameter("roomtype");
    if((roomtype == null) || (roomtype.length() == 0))
    {
      printMsg("Please enter a roomtype!", writer, request);
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
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          String sql = "INSERT INTO bookings (user_id, hotel, persons, nights, roomtype) VALUES("+ ((user)sess.getValue("user")).getAccNum() + ", '" + hotel + "'," + persons + "," + nights + ",'"+ roomtype +"')";
          Statement statement = connection.createStatement();
          statement.executeUpdate(sql);
          printMsg("Booking for " + hotel + " recieved!", writer, request);
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
  }

  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h1>" + msg + "</h1>\n");
    writer.write("<form action=\"mainpage\" method=\"GET\">\n");
    writer.write("<p><input style=\"margin-left: 2em\"type =\"submit\" value =\"Back\"/></p>\n");
    writer.write("</form>\n");
    writer.write("<hr/>");
    writer.write("</div>");
    writer.write("<div id=\"footer\">");
    writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | ");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>");
    writer.write("</p>");
    writer.write("</div>");
    writer.write("</body>");
    writer.write("</html>");
  }
}