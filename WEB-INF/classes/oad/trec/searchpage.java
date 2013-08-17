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

public class searchpage extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\"\n");
    writer.write("\"http://www.w3.org/TR/RBC-html40/loose.dtd\">\n");
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>Searchpage</title>\n");
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
    writer.write("<fieldset style=\"width:885px;\">\n");
    writer.write("<legend style=\"color: black\">Search</legend>\n");
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");
    writer.write("<form action=\"search\" method=\"GET\">\n");
    writer.write("<table style=\"margin-left: 10em\">\n");
    writer.write("<tr>\n");
    writer.write("<th>Country</th>\n");
    writer.write("<th>Destination</th>\n");
    writer.write("<th>City</th>\n");
    writer.write("</tr><tr>\n");
    writer.write("<th>\n");
    writer.write("<select name=\"country\" size=\"5\">\n");
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
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
          Statement statement = connection.createStatement();
          ResultSet query_result = statement.executeQuery("SELECT country.name FROM country");

          while(query_result.next())
          {
            String country_name = query_result.getString("country.name");
            writer.write("<option value = \""+ country_name +"\">"+ country_name +"</option>\n");
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
    writer.write("</select>\n");
    writer.write("</th>\n");
    writer.write("<th>\n");
    writer.write("<select name=\"destination\" size=\"5\">\n");

    try
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
    catch(SQLException exc)
    {
      exc.printStackTrace();
      //printMsg("database error!", writer, request);
    }
    writer.write("</select>\n");
    writer.write("</th>\n");
    writer.write("<th>\n");
    writer.write("<select name=\"city\" size=\"5\">\n");

    try
    {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      Statement statement = connection.createStatement();
      ResultSet query_result = statement.executeQuery("SELECT citys.city FROM citys");
      while(query_result.next())
      {
        String city_name = query_result.getString("citys.city");
        writer.write("<option value = \""+ city_name +"\">"+ city_name +"</option>\n");
      }
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      //printMsg("database error!", writer, request);
    }
    writer.write("</select>\n");
    writer.write("</th>\n");
    writer.write("</tr><tr>\n");
    writer.write("<th>Arrival Date</th>\n");
    writer.write("<th>Departure Date</th>\n");
    writer.write("<th>Number of Travellers</th>\n");
    writer.write("</tr><tr><th>\n");
    writer.write("<select name=\"arrivaldateday\" size=\"1\">\n");
    writer.write("<option value=\"1\">1</option>\n");
    writer.write("<option value=\"2\">2</option>\n");
    writer.write("<option value=\"3\">3</option>\n");
    writer.write("<option value=\"4\">4</option>\n");
    writer.write("<option value\"5\">5</option>\n");
    writer.write("<option value=\"6\">6</option>\n");
    writer.write("<option value=\"7\">7</option>\n");
    writer.write("<option value=\"8\">8</option>\n");
    writer.write("<option value=\"9\">9</option>\n");
    writer.write("<option value=\"10\">10</option>\n");
    writer.write("<option value=\"11\">11</option>\n");
    writer.write("<option value=\"12\">12</option>\n");
    writer.write("<option value=\"13\">13</option>\n");
    writer.write("<option value=\"14\">14</option>\n");
    writer.write("<option value=\"15\">15</option>\n");
    writer.write("<option value=\"16\">16</option>\n");
    writer.write("<option value=\"17\">17</option>\n");
    writer.write("<option value=\"18\">18</option>\n");
    writer.write("<option value=\"19\">19</option>\n");
    writer.write("<option value=\"20\">20</option>\n");
    writer.write("<option value=\"21\">21</option>\n");
    writer.write("<option value=\"22\">22</option>\n");
    writer.write("<option value=\"23\">23</option>\n");
    writer.write(" <option value=\"24\">24</option>\n");
    writer.write("<option value=\"25\">25</option>\n");
    writer.write("<option value=\"26\">26</option>\n");
    writer.write("<option value=\"27\">27</option>\n");
    writer.write("<option value=\"28\">28</option>\n");
    writer.write("<option value=\"29\">29</option>\n");
    writer.write("<option value=\"30\">30</option>\n");
    writer.write("<option value=\"31\">31</option>\n");
    writer.write("</select>\n");
    writer.write("<select name=\"arrivaldatemonth\" size=\"1\">\n");
    writer.write("<option value=\"January\">January</option>\n");
    writer.write("<option value=\"February\">February</option>\n");
    writer.write("<option value=\"March\">March</option>\n");
    writer.write("<option value=\"April\">April</option>\n");
    writer.write("<option value=\"May\">May</option>\n");
    writer.write("<option value=\"June\">June</option>\n");
    writer.write("<option value=\"July\">July</option>\n");
    writer.write("<option value=\"August\">August</option>\n");
    writer.write("<option value=\"September\">September</option>\n");
    writer.write("<option value=\"October\">October</option>\n");
    writer.write("<option value=\"November\">November</option>\n");
    writer.write("<option value=\"December\">December</option>\n");
    writer.write("</select>\n");
    writer.write("</th>\n");
    writer.write("<th>\n");
    writer.write("<select name=\"departuredateday\" size=\"1\">\n");
    writer.write("<option value=\"1\">1</option>\n");
    writer.write("<option value=\"2\">2</option>\n");
    writer.write("<option value=\"3\">3</option>\n");
    writer.write("<option value=\"4\">4</option>\n");
    writer.write("<option value=\"5\">5</option>\n");
    writer.write("<option value=\"6\">6</option>\n");
    writer.write("<option value=\"7\">7</option>\n");
    writer.write("<option value=\"8\">8</option>\n");
    writer.write("<option value=\"9\">9</option>\n");
    writer.write("<option value=\"10\">10</option>\n");
    writer.write("<option value=\"11\">11</option>\n");
    writer.write("<option value=\"12\">12</option>\n");
    writer.write("<option value=\"13\">13</option>\n");
    writer.write("<option value=\"14\">14</option>\n");
    writer.write("<option value=\"15\">15</option>\n");
    writer.write("<option value=\"16\">16</option>\n");
    writer.write("<option value=\"17\">17</option>\n");
    writer.write("<option value=\"18\">18</option>\n");
    writer.write("<option value=\"19\">19</option>\n");
    writer.write("<option value=\"20\">20</option>\n");
    writer.write("<option value=\"21\">21</option>\n");
    writer.write("<option value=\"22\">22</option>\n");
    writer.write("<option value=\"23\">23</option>\n");
    writer.write("<option value=\"24\">24</option>\n");
    writer.write("<option value=\"25\">25</option>\n");
    writer.write("<option value=\"26\">26</option>\n");
    writer.write("<option value=\"27\">27</option>\n");
    writer.write("<option value=\"28\">28</option>\n");
    writer.write("<option value=\"29\">29</option>\n");
    writer.write("<option value=\"30\">30</option>\n");
    writer.write("<option value=\"31\">31</option>\n");
    writer.write("</select>\n");
    writer.write("<select name=\"departuredatemonth\" size=\"1\">\n");
    writer.write("<option value=\"January\">January</option>\n");
    writer.write("<option value=\"February\">February</option>\n");
    writer.write("<option value=\"March\">March</option>\n");
    writer.write("<option value=\"April\">April</option>\n");
    writer.write("<option value=\"May\">May</option>\n");
    writer.write("<option value=\"June\">June</option>\n");
    writer.write("<option value=\"July\">July</option>\n");
    writer.write("<option value=\"August\">August</option>\n");
    writer.write("<option value=\"September\">September</option>\n");
    writer.write("<option value=\"October\">October</option>\n");
    writer.write("<option value=\"November\">November</option>\n");
    writer.write("<option value=\"December\">December</option>\n");
    writer.write("</select>\n");
    writer.write("</th>\n");
    writer.write("<th>\n");
    writer.write("<select name=\"travellers\" size=\"1\">\n");
    writer.write("<option value=\"1\">1</option>\n");
    writer.write("<option value=\"2\">2</option>\n");
    writer.write("<option value=\"3\">3</option>\n");
    writer.write("<option value=\"4\">4</option>\n");
    writer.write("</select>\n");
    writer.write("</th>\n");
    writer.write("</tr>\n");
    writer.write("<tr>\n");
    writer.write("<td>\n");
    writer.write("</td>\n");
    writer.write("<td>\n");
    writer.write("<input style=\"margin-left: 12em\"type =\"submit\" value =\"Search\"/>\n");
    writer.write("</form>\n");
    writer.write("</td>\n");
    writer.write("<td>\n");
    writer.write("<form action=\"mainpage\" method=\"GET\">\n");
    writer.write("<p><input style=\"margin-left: 2em\"type =\"submit\" value =\"Back\"/></p>\n");
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
