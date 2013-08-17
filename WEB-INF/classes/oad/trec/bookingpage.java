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

public class bookingpage extends HttpServlet{

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
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");
    writer.write("<div id=\"booking\">\n");
    writer.write("<form action=\"booking\" method=\"GET\">\n");
    writer.write("<table><tr>\n");
    String hotel_id = request.getParameter("hotel_id");
    String hotel_name = null;
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
      Statement statement = connection.createStatement();
      ResultSet query_result = statement.executeQuery("SELECT hotel.name FROM hotel WHERE hotel.id = "+hotel_id+"");
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          while(query_result.next())
          {
            hotel_name = query_result.getString("hotel.name");
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
      //printMsg("database error!", writer, request);
    }
    writer.write("<td><p>Hotel: </td><td> <input type =\"text\" name =\"hotel\" size=\"20\" maxlength=\"70\" value=\""+hotel_name+" \"/></td></tr><tr></p>\n");
    String destination = request.getParameter("destination");
    writer.write("<p><td>Destination: </td><td> <input type =\"text\" name =\"destination\" size=\"20\" maxlength=\"50\" value=\""+destination+" \"/></td></tr><tr></p>\n");
    writer.write("<p><td>Persons: </td><td><select name=\"persons\" size=\"1\">\n");
    writer.write("<option value = \"1\">1</option>\n");
    writer.write("<option value = \"2\">2</option>\n");
    writer.write("<option value = \"3\">3</option>\n");
    writer.write("<option value = \"4\">4</option></td></tr><tr></p>\n");
    writer.write("<p><td>Nights: </td><td><select name=\"nights\" size=\"1\">\n");
    writer.write("<option value = \"1\">1</option>\n");
    writer.write("<option value = \"2\">2</option>\n");
    writer.write("<option value = \"3\">3</option>\n");
    writer.write("<option value = \"4\">4</option></td></tr><tr></p>\n");
    writer.write("<p><td>Roomtype: </td><td><select name=\"roomtype\" size=\"1\">\n");
    writer.write("<option value = \"Single\">Single</option>\n");
    writer.write("<option value = \"Double\">Double</option>\n");
    writer.write("<option value = \"Penthouse\">Penthouse</option>\n");
    writer.write("<option value = \"PresidentSuite\">PresidentSuite</option>\n");
    writer.write("<option value = \"WeddingSuite\">WeddingSuite</option>\n");
    writer.write("<option value = \"Apartments\">Apartments</option></td></tr><tr></p>\n");
    writer.write("</td></tr></table>\n");
    writer.write("<p><input type =\"submit\" value =\"Book\"/></p>\n");
    writer.write("</form>\n");
    writer.write("</div>\n");
    printMsg("",writer, request);
  }

  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h1>" + msg + "</h1>\n");
    writer.write("<hr/>");
    writer.write("<div id=\"footer\">");
    writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | ");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>");
    writer.write("</p>");
    writer.write("</div>");
    writer.write("</body>");
    writer.write("</html>");
  }
}