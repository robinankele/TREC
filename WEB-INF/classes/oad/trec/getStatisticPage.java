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

public class getStatisticPage extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\"\n");
    writer.write("\"http://www.w3.org/TR/RBC-html40/loose.dtd\">\n");
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>Get Statistic Page</title>\n");
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"main.css\" />\n");
    writer.write("</head>\n");
    writer.write("<body>\n");

    writer.write("<div id=\"header\">\n");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\" />\n");
    writer.write("</div>\n");
    writer.write("<div id=\"socialNetworkBox\">\n");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>\n");
    writer.write("</div>\n");
    writer.write("<div id=\"search\">\n");
    writer.write("<fieldset>\n");
    writer.write("<legend style=\"color: black\">Search</legend>\n");
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");
    writer.write("<form action=\"getStatistic\" method=\"GET\">\n");
    writer.write("<h2>Please select a Destination.</h2>\n");
    writer.write("<table>\n");
    writer.write("<tr>\n");
    writer.write("<th>\n");
    writer.write("<select name=\"destination\" size=\"5\">\n");

    try
    {
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
          Statement statement = connection.createStatement();
          ResultSet query_result = statement.executeQuery("SELECT destination.name FROM destination");
          while(query_result.next())
          {
            String destination_location = query_result.getString("destination.name");
            writer.write("<option value = \""+ destination_location +"\">"+ destination_location +"</option>\n");
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
    }
    writer.write("</select>\n");
    writer.write("</th>\n");
    writer.write("</tr>\n");
    writer.write("<tr>\n");
    writer.write("<td>\n");
    writer.write("<input style=\"margin-left: 0px\"type =\"submit\" value =\"Get Statistic\"/>\n");
    writer.write("</form>\n");
    writer.write("</td>\n");
    writer.write("<td>\n");
    writer.write("<form action=\"mainpage\" method=\"GET\">\n");
    writer.write("<p><input style=\"margin-left: 0px\"type =\"submit\" value =\"Cancel\"/></p>\n");
    writer.write("</form>\n");
    writer.write("</td>\n");
    writer.write("</tr>\n");
    writer.write("</table>\n");

    writer.write("</fieldset>\n");
    writer.write("</div>\n");
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
