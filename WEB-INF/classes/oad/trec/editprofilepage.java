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

public class editprofilepage extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    HttpSession session = request.getSession(true);
    if(session.getValue("user") != null)
    {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>Edit Profile</title>");
        writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<div id=\"header\" align = \"center\">");
        writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>");
        writer.write("</div>");
        writer.write("<div id=\"socialNetworkBox\">");
        writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>");
        writer.write("</div>");
        writer.write("<div id=\"edit\">");
        writer.write("<fieldset>");
        writer.write("<legend style=\"color: black\">Edit Profile</legend>");
        writer.write("<form action=\"logout\" method=\"GET\">");
        writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>");
        writer.write("</form>");
        writer.write("<p>Please enter only 3 Interests and 3 Activities!</p>");
        writer.write("<form action=\"edit\" method=\"GET\">");
        writer.write("<table>");
        writer.write("<tr>");
        writer.write("<th><h2>Main Data</h2></th>");
        writer.write("<th><h2>Interests</h2></th>");
        writer.write("<th><h2>Activities</h2></th>");
        writer.write("</tr>");
        writer.write("<tr>");
        writer.write("<td>");

        writer.write("<p>First Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("&nbsp;&nbsp;<input type =\"text\" name =\"first_name\" ");
        writer.write("size=\"20\" maxlength=\"50\" value=\" "+ getFirstName(request, writer) +" \">");
        writer.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>");

        writer.write("<p>Last Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("&nbsp;&nbsp;<input type =\"text\" name =\"last_name\" ");
        writer.write("size=\"20\" maxlength=\"50\" value=\"" + getLastName(request, writer) +"\"></p>");

        writer.write("<p>Old Password:&nbsp;&nbsp;&nbsp;&nbsp;<input type ");
        writer.write("=\"password\" name =\"old_password\" size=\"20\" ");
        writer.write("maxlength=\"50\" /></p>");

        writer.write("<p>New Password:&nbsp;&nbsp;<input type =\"password\" name ");
        writer.write("=\"new_password\" size=\"20\" maxlength=\"50\" /></p>");

        writer.write("<p>New Password:&nbsp;&nbsp;<input type =\"password\" name ");
        writer.write("=\"new_password2\" size=\"20\" maxlength=\"50\" /></p>");

        writer.write("<p>E-Mail Adress:&nbsp;&nbsp;&nbsp;<input type =\"text\" ");
        writer.write("name =\"email\" size=\"20\" maxlength=\"50\" value=\""+getEmail(request, writer) +"\"></p>");

        writer.write("</td>");
        writer.write("<td>");
        writer.write("<p> <b>First Interest</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"firstint\" size=\"1\">");
        writer.write("<option value=\"0\">Choose your interest</option>");
        writer.write("<option value=\"1\">Business</option>");
        writer.write("<option value=\"2\">Nature</option>");
        writer.write("<option value=\"3\">Sports</option>");
        writer.write("<option value=\"4\">Family</option>");
        writer.write("<option value=\"5\">Culture</option>");
        writer.write("<option value=\"6\">Country-Holiday</option>");
        writer.write("<option value=\"7\">Winter-Holiday</option>");
        writer.write("<option value=\"8\">Summer-Holiday</option>");
        writer.write("</select>");

        writer.write("<p> Value &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"intvalueone\" size=\"1\">");
        writer.write("<option value=\"0 \">0</option>");
        writer.write("<option value=\"1 \">1</option>");
        writer.write("<option value=\"2\">2</option>");
        writer.write("<option value=\"3\">3</option>");
        writer.write("<option value=\"4\">4</option>");
        writer.write("<option value=\"5\">5</option>");
        writer.write("<option value=\"6\">6</option>");
        writer.write("<option value=\"7\">7</option>");
        writer.write("<option value=\"8\">8</option>");
        writer.write("<option value=\"9\">9</option>");
        writer.write("<option value=\"10\">10</option>");
        writer.write("</select>");

        writer.write("<p> <b>Second Interest</b> &nbsp;");
        writer.write("<select name=\"secondint\" size=\"1\">");
        writer.write("<option value=\"0\">Choose your interest</option>");
        writer.write("<option value=\"1\">Business</option>");
        writer.write("<option value=\"2\">Nature</option>");
        writer.write("<option value=\"3\">Sports</option>");
        writer.write("<option value=\"4\">Family</option>");
        writer.write("<option value=\"5\">Culture</option>");
        writer.write("<option value=\"6\">Country-Holiday</option>");
        writer.write("<option value=\"7\">Winter-Holiday</option>");
        writer.write("<option value=\"8\">Summer-Holiday</option>");
        writer.write("</select>");


        writer.write("<p> Value &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"intvaluetwo\" size=\"1\">");
        writer.write("<option value=\"0 \">0</option>");
        writer.write("<option value=\"1 \">1</option>");
        writer.write("<option value=\"2\">2</option>");
        writer.write("<option value=\"3\">3</option>");
        writer.write("<option value=\"4\">4</option>");
        writer.write("<option value=\"5\">5</option>");
        writer.write("<option value=\"6\">6</option>");
        writer.write("<option value=\"7\">7</option>");
        writer.write("<option value=\"8\">8</option>");
        writer.write("<option value=\"9\">9</option>");
        writer.write("<option value=\"10\">10</option>");
        writer.write("</select>");

        writer.write("<p> <b>Third interest</b> &nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"thirdint\" size=\"1\">");
        writer.write("<option value=\"0\">Choose your interest</option>");
        writer.write("<option value=\"1\">Business</option>");
        writer.write("<option value=\"2\">Nature</option>");
        writer.write("<option value=\"3\">Sports</option>");
        writer.write("<option value=\"4\">Family</option>");
        writer.write("<option value=\"5\">Culture</option>");
        writer.write("<option value=\"6\">Country-Holiday</option>");
        writer.write("<option value=\"7\">Winter-Holiday</option>");
        writer.write("<option value=\"8\">Summer-Holiday</option>");
        writer.write("</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");

        writer.write("<p> Value &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"intvaluethree\" size=\"1\">");
        writer.write("<option value=\"0\">0</option>");
        writer.write("<option value=\"1\">1</option>");
        writer.write("<option value=\"2\">2</option>");
        writer.write("<option value=\"3\">3</option>");
        writer.write("<option value=\"4\">4</option>");
        writer.write("<option value=\"5\">5</option>");
        writer.write("<option value=\"6\">6</option>");
        writer.write("<option value=\"7\">7</option>");
        writer.write("<option value=\"8\">8</option>");
        writer.write("<option value=\"9\">9</option>");
        writer.write("<option value=\"10\">10</option>");
        writer.write("</select>");
        writer.write("</td>");

        writer.write("<td>");
        writer.write("<p> <b>First activity</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"firstact\" size=\"1\">");
        writer.write("<option value=\"0\">Choose an activity</option>");
        writer.write("<option value=\"1\">Wellness</option>");
        writer.write("<option value=\"2\">Tennis</option>");
        writer.write("<option value=\"3\">Skiing</option>");
        writer.write("<option value=\"4\">Hiking</option>");
        writer.write("<option value=\"5\">Sightseeing</option>");
        writer.write("<option value=\"6\">Snorkeling</option>");
        writer.write("<option value=\"7\">Shopping</option>");
        writer.write("<option value=\"8\">Children-Club</option>");
        writer.write("<option value=\"9\">Aqua Park</option>");
        writer.write("</select>");

        writer.write("<p> Value &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"actvalueone\" size=\"1\">");
        writer.write("<option value=\"0\">0</option>");
        writer.write("<option value=\"1\">1</option>");
        writer.write("<option value=\"2\">2</option>");
        writer.write("<option value=\"3\">3</option>");
        writer.write("<option value=\"4\">4</option>");
        writer.write("<option value=\"5\">5</option>");
        writer.write("<option value=\"6\">6</option>");
        writer.write("<option value=\"7\">7</option>");
        writer.write("<option value=\"8\">8</option>");
        writer.write("<option value=\"9\">9</option>");
        writer.write("<option value=\"10\">10</option>");
        writer.write("</select>");

        writer.write("<p> <b>Second activity</b> &nbsp;");
        writer.write("<select name=\"secondact\" size=\"1\">");
        writer.write("<option value=\"0\">Choose an activity</option>");
        writer.write("<option value=\"1\">Wellness</option>");
        writer.write("<option value=\"2\">Tennis</option>");
        writer.write("<option value=\"3\">Skiing</option>");
        writer.write("<option value=\"4\">Hiking</option>");
        writer.write("<option value=\"5\">Sightseeing</option>");
        writer.write("<option value=\"6\">Snorkeling</option>");
        writer.write("<option value=\"7\">Shopping</option>");
        writer.write("<option value=\"8\">Children-Club</option>");
        writer.write("<option value=\"9\">Aqua Park</option>");
        writer.write("</select>");

        writer.write("<p> Value &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"actvaluetwo\" size=\"1\">");
        writer.write("<option value=\"0\">0</option>");
        writer.write("<option value=\"1\">1</option>");
        writer.write("<option value=\"2\">2</option>");
        writer.write("<option value=\"3\">3</option>");
        writer.write("<option value=\"4\">4</option>");
        writer.write("<option value=\"5\">5</option>");
        writer.write("<option value=\"6\">6</option>");
        writer.write("<option value=\"7\">7</option>");
        writer.write("<option value=\"8\">8</option>");
        writer.write("<option value=\"9\">9</option>");
        writer.write("<option value=\"10\">10</option>");
        writer.write("</select>");

        writer.write("<p> <b>Third activity</b> &nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"thirdact\" size=\"1\">");
        writer.write("<option value=\"0\">Choose an activity</option>");
        writer.write("<option value=\"1\">Wellness</option>");
        writer.write("<option value=\"2\">Tennis</option>");
        writer.write("<option value=\"3\">Skiing</option>");
        writer.write("<option value=\"4\">Hiking</option>");
        writer.write("<option value=\"5\">Sightseeing</option>");
        writer.write("<option value=\"6\">Snorkeling</option>");
        writer.write("<option value=\"7\">Shopping</option>");
        writer.write("<option value=\"8\">Children-Club</option>");
        writer.write("<option value=\"9\">Aqua Park</option>");
        writer.write("</select> ");

        writer.write("<p> Value &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        writer.write("<select name=\"actvaluethree\" size=\"1\">");
        writer.write("<option value=\"0\">0</option>");
        writer.write("<option value=\"1\">1</option>");
        writer.write("<option value=\"2\">2</option>");
        writer.write("<option value=\"3\">3</option>");
        writer.write("<option value=\"4\">4</option>");
        writer.write("<option value=\"5\">5</option>");
        writer.write("<option value=\"6\">6</option>");
        writer.write("<option value=\"7\">7</option>");
        writer.write("<option value=\"8\">8</option>");
        writer.write("<option value=\"9\">9</option>");
        writer.write("<option value=\"10\">10</option>");
        writer.write("</select>");
        writer.write("</td>");
        writer.write("</tr>");

        writer.write("<td>");
        writer.write("<table>");
        writer.write("<td><tr>");
        writer.write("<input type =\"submit\" value =\"Save\"/>");
        writer.write("</form></tr><tr>");
        writer.write("<form action=\"mainpage\" method=\"GET\">");
        writer.write("<input style=\"margin-left: 50px\"type =\"submit\" value =\"Cancel\"/>");
        writer.write("</td></tr>");
        writer.write("</table>");
        writer.write("</td>");
        writer.write("</form>");

        writer.write("</table>");
        writer.write("</fieldset>");
        writer.write("</div>");

    try
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
        Statement statement = connection.createStatement();
        HttpSession sess = request.getSession(true);
        String sessid = sess.getId();
        user testuser;
        if(sess.getValue("user") == null)
        {
           response.sendRedirect(""+"index.html");
        }        
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("Cannot find user: database error!", writer, request);
    }
    printMsg("",writer, request);
  }
  else
  {
        response.sendRedirect(""+"index.html");
  }
}
  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){

    writer.write("<h1 style=\"clear: left;\">" + msg + "</h1>");
    writer.write("<hr/>");
    writer.write("<div id=\"footer\">");
    writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> |");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>");
    writer.write("</p>");
    writer.write("</div>");
    writer.write("</body>");
    writer.write("</html>");

  }
  
  private String getFirstName(HttpServletRequest request, PrintWriter writer)
  {
    String first_name = ""; 
    try
    {

      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          String userid = ((user)sess.getValue("user")).getAccNum();
          Statement statement = connection.createStatement();
          ResultSet query_result = statement.executeQuery("SELECT FirstName FROM user WHERE id ="+ userid);
          if(query_result.next())
          {
              first_name = query_result.getString("FirstName");
          }
          return first_name;
       }
      return "";
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("database error!", writer, request);
      return "";
    }
  }
  
  private String getLastName(HttpServletRequest request, PrintWriter writer)
  {
    String last_name = ""; 
    try
    {

      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          String userid = ((user)sess.getValue("user")).getAccNum();
          Statement statement = connection.createStatement();
          ResultSet query_result = statement.executeQuery("SELECT LastName FROM user WHERE id ="+ userid);
          if(query_result.next())
          {
              last_name = query_result.getString("LastName");
          }
          return last_name;
       }
      return "";
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("database error!", writer, request);
      return "";
    }
  }
  
  private String getEmail(HttpServletRequest request, PrintWriter writer)
  {
    String email = ""; 
    try
    {

      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          String userid = ((user)sess.getValue("user")).getAccNum();
          Statement statement = connection.createStatement();
          ResultSet query_result = statement.executeQuery("SELECT Email FROM user WHERE id ="+ userid);
          if(query_result.next())
          {
              email = query_result.getString("Email");
          }
          return email;
       }
      return "";
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("database error!", writer, request);
      return "";
    }
  }
}
