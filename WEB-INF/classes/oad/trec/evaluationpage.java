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

public class evaluationpage extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>EvaluationPage</title>\n");
    writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
    writer.write("</head>");
    writer.write("<body>");
    writer.write("<div id=\"header\" align = \"center\">");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>");
    writer.write("</div>");
    writer.write("<div id=\"socialNetworkBox\">");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>");
    writer.write("</div>");
    
    writer.write("<div id =\"evaluate\">\n");
    writer.write("<fieldset>\n");
    writer.write("<legend>Hotel-Evaluation</legend>\n");
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");

    writer.write("<form action=\"evaluation\" method=\"GET\" style=\"float: left;\">\n");
    
      //begin hotel
    writer.write("<table><tr><th><h2>Choose Hotel:</h2></th>\n");

    //begin drop down
    writer.write("<th><select name=\"Hotel\" size=\"5\">\n");
    try
    {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      Statement statement = connection.createStatement();
      ResultSet query_result = statement.executeQuery("SELECT hotel.name FROM hotel");

      String hotel_name;
      if(query_result.next())
      {
        hotel_name = query_result.getString("hotel.name");
        writer.write("<option  selected value = \""+ hotel_name +"\">"+ hotel_name +"</option>\n");
      }

      while(query_result.next())
      {
          hotel_name = query_result.getString("hotel.name");
          writer.write("<option value = \""+ hotel_name +"\">"+ hotel_name +"</option>\n");
      }
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("database error!", writer, request);
    }

    //textarea for comment
    writer.write("</th></tr></table><p> <br><textarea name=\"user_comment\" cols=\"50\" rows=\"7\">Please enter your comment to the hotel here ...</textarea></p>\n");
    
    //days of the stay
    writer.write("<p> Days of staying there: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
    writer.write("<select name=\"days\" size=\"1\">\n");
    writer.write("<option value=\"1 \">1</option>\n");
    writer.write("<option value=\"2\">2</option>\n");
    writer.write("<option value=\"3\">3</option>\n");
    writer.write("<option value=\"4\">4</option>\n");
    writer.write("<option value=\"5\">5</option>\n");
    writer.write("<option value=\"6\">6</option>\n");
    writer.write("<option value=\"7\">7</option>\n");
    writer.write("<option value=\"8\">8</option>\n");
    writer.write("<option value=\"9\">9</option>\n");
    writer.write("<option value=\"10\">10</option>\n");
    writer.write("<option value=\"14\">14</option>\n");
    writer.write("<option value=\"21\">21</option>\n");
    writer.write("</select>\n");

    writer.write("<h2>Give every part of the hotel  0 - 6 stars:</h2>\n");
    writer.write("<p>\n");
    writer.write("<table border=\"0\">\n");
    writer.write("<colgroup width=\"50%\" span=\"2\"></colgroup>");
    writer.write("<tr>\n");
    writer.write("<th>0 &nbsp 1 &nbsp&nbsp 2 &nbsp&nbsp 3 &nbsp&nbsp 4 &nbsp&nbsp 5 &nbsp 6</th>\n");
    writer.write("</tr>\n");
    writer.write("<td>Hotel General</td>\n");
    writer.write("<td>\n");
    writer.write("<input type=\"radio\" name=\"HotelAllgemein\" value=\"0\">\n");
    writer.write("<input type=\"radio\" name=\"HotelAllgemein\" value=\"1\">\n");
    writer.write("<input type=\"radio\" name=\"HotelAllgemein\" value=\"2\">\n");
    writer.write("<input type=\"radio\" name=\"HotelAllgemein\" value=\"3\" checked>\n");
    writer.write("<input type=\"radio\" name=\"HotelAllgemein\" value=\"4\">\n");
    writer.write("<input type=\"radio\" name=\"HotelAllgemein\" value=\"5\">\n");
    writer.write("<input type=\"radio\" name=\"HotelAllgemein\" value=\"6\">\n");
    writer.write("</td>\n");
    writer.write("</tr>\n");

    writer.write("<tr>\n");
    writer.write("<td>Rooms</td>\n");
    writer.write("<td>\n");
    writer.write("<input type=\"radio\" name=\"Zimmer\" value=\"0\">\n");
    writer.write("<input type=\"radio\" name=\"Zimmer\" value=\"1\">\n");
    writer.write("<input type=\"radio\" name=\"Zimmer\" value=\"2\">\n");
    writer.write("<input type=\"radio\" name=\"Zimmer\" value=\"3\" checked>\n");
    writer.write("<input type=\"radio\" name=\"Zimmer\" value=\"4\">\n");
    writer.write("<input type=\"radio\" name=\"Zimmer\" value=\"5\">\n");
    writer.write("<input type=\"radio\" name=\"Zimmer\" value=\"6\">\n");
    writer.write("</td>\n");
    writer.write("</tr>\n");

    writer.write("<tr>\n");
    writer.write("<td>Service</td>\n");
    writer.write("<td>\n");
    writer.write("<input type=\"radio\" name=\"Service\" value=\"0\">\n");
    writer.write("<input type=\"radio\" name=\"Service\" value=\"1\">\n");
    writer.write("<input type=\"radio\" name=\"Service\" value=\"2\">\n");
    writer.write("<input type=\"radio\" name=\"Service\" value=\"3\" checked>\n");
    writer.write("<input type=\"radio\" name=\"Service\" value=\"4\">\n");
    writer.write("<input type=\"radio\" name=\"Service\" value=\"5\">\n");
    writer.write("<input type=\"radio\" name=\"Service\" value=\"6\">\n");
    writer.write("</td>\n");
    writer.write("</tr>\n");

    writer.write("<tr>\n");
    writer.write("<td>Location</td>\n");
    writer.write("<td>\n");
    writer.write("<input type=\"radio\" name=\"Lage\" value=\"0\">\n");
    writer.write("<input type=\"radio\" name=\"Lage\" value=\"1\">\n");
    writer.write("<input type=\"radio\" name=\"Lage\" value=\"2\">\n");
    writer.write("<input type=\"radio\" name=\"Lage\" value=\"3\" checked>\n");
    writer.write("<input type=\"radio\" name=\"Lage\" value=\"4\">\n");
    writer.write("<input type=\"radio\" name=\"Lage\" value=\"5\">\n");
    writer.write("<input type=\"radio\" name=\"Lage\" value=\"6\">\n");
    writer.write("</td>\n");
    writer.write("</tr>\n");

    writer.write("<tr>\n");
    writer.write("<td>Food</td>\n");
    writer.write("<td>\n");
    writer.write("<input type=\"radio\" name=\"Gastronomie\" value=\"0\">\n");
    writer.write("<input type=\"radio\" name=\"Gastronomie\" value=\"1\">\n");
    writer.write("<input type=\"radio\" name=\"Gastronomie\" value=\"2\">\n");
    writer.write("<input type=\"radio\" name=\"Gastronomie\" value=\"3\" checked>\n");
    writer.write("<input type=\"radio\" name=\"Gastronomie\" value=\"4\">\n");
    writer.write("<input type=\"radio\" name=\"Gastronomie\" value=\"5\">\n");
    writer.write("<input type=\"radio\" name=\"Gastronomie\" value=\"6\">\n");
    writer.write("</td>\n");
    writer.write("</tr>\n");

    writer.write("<tr>\n");
    writer.write("<td>Sports and Entertainment</td>\n");
    writer.write("<td>\n");
    writer.write("<input type=\"radio\" name=\"Sport und Unterhaltung\" value=\"0\">\n");
    writer.write("<input type=\"radio\" name=\"Sport und Unterhaltung\" value=\"1\">\n");
    writer.write("<input type=\"radio\" name=\"Sport und Unterhaltung\" value=\"2\">\n");
    writer.write("<input type=\"radio\" name=\"Sport und Unterhaltung\" value=\"3\" checked>\n");
    writer.write("<input type=\"radio\" name=\"Sport und Unterhaltung\" value=\"4\">\n");
    writer.write("<input type=\"radio\" name=\"Sport und Unterhaltung\" value=\"5\">\n");
    writer.write("<input type=\"radio\" name=\"Sport und Unterhaltung\" value=\"6\">\n");
    writer.write("</td>\n");
    writer.write("</tr>\n");
    writer.write("<tr>\n");
    writer.write("<td>\n");
    writer.write("<p><input type =\"submit\" value =\"Send Evaluation\"/></p>\n");
    writer.write("</form>\n");
    writer.write("</td>\n");
    writer.write("<td>\n");
    writer.write("<form action=\"mainpage\" method=\"GET\">");
    writer.write("<p><input style=\"margin-left: 50px\"type =\"submit\" value =\"Cancel\"/></p>");
    writer.write("</form>\n");
    writer.write("</td>\n");
    writer.write("</tr>\n");
    writer.write("</table>\n");
    writer.write("</fieldset>\n");
    writer.write("</div>\n");
    printMsg("", writer, request);
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
