package oad.trec;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.io.IOException;
import java.io.PrintWriter;

public class admindatabaselistdb extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
      writer.write("<html>\n");
      writer.write("<head>\n");
      writer.write("<title>Edit Profile</title>\n");
      writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
      writer.write("</head>");
      writer.write("<body>");
      writer.write("<div id=\"header\" align = \"center\">");
      writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>");
      writer.write("</div>");
      writer.write("<div id=\"socialNetworkBox\">");
      writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>");
      writer.write("</div>\n");

      writer.write("<div id =\"evaluate\">\n");
      writer.write("<fieldset>\n");
      writer.write("<legend>SQL-Query</legend>\n");
      writer.write("<form action=\"logout\" method=\"GET\">\n");
      writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>\n");
      writer.write("</form>\n");
      writer.write("<form action=\"admindatabasepageresult\" method=\"GET\">\n");
      writer.write("<textarea name=\"sql\" cols=\"50\" rows=\"7\">SQL - Query hier eingeben ...</textarea></td>\n");
      writer.write("<table><tr>\n");
      writer.write("<td><input type =\"submit\" value =\"SQL\"/></td>\n");
      writer.write("</form>\n");
      writer.write("<form action=\"admindatabasepage\" method=\"GET\">\n");
      writer.write("<td><input style=\"margin-left:50px\" type =\"submit\" value =\"Cancel\"/></td>\n");
      writer.write("</tr></table>\n");
      writer.write("</form>\n");

      String table = request.getParameter("table");
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
            ResultSet query_result = null;
            if(table.equals("1"))
            {
                query_result = statement.executeQuery("SELECT id,username  FROM activeuser");
                writer.write("<h2>activeuser - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>username</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String username = query_result.getString("username");
                    writer.write("<tr><td>"+ id +"</td><td>"+ username +"</td></tr>\n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("2"))
            {
                query_result = statement.executeQuery("SELECT id,name  FROM activities");
                writer.write("<h2>activities - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>name</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String name = query_result.getString("name");
                    writer.write("<tr><td>"+ id +"</td><td>"+ name +"</td></tr>\n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("3"))
            {
                query_result = statement.executeQuery("SELECT id,country_id,city,destination_id,weather,popularity FROM citys");
                writer.write("<h2>citys - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>country_id</td><td>city</td><td>destination_id</td><td>weather</td><td>popularity</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String country_id = query_result.getString("country_id");
                    String city = query_result.getString("city");
                    String destination_id = query_result.getString("destination_id");
                    String weather = query_result.getString("weather");
                    String popularity = query_result.getString("popularity");
                    writer.write("<tr><td>"+id+"</td><td>"+country_id+"</td><td>"+city+"</td><td>"+destination_id+"</td><td>"+weather+"</td><td>"+popularity+"</td></tr> \n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("4"))
            {
                query_result = statement.executeQuery("SELECT Id,FirstName,LastName,Email,username,password,admin FROM user");
                writer.write("<h2>user - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>Id</td><td>FirstName</td><td>LastName</td><td>Email</td><td>username</td><td>password</td><td>admin</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("Id");
                    String firstname = query_result.getString("FirstName");
                    String lastname = query_result.getString("LastName");
                    String email = query_result.getString("Email");
                    String username = query_result.getString("username");
                    String password = query_result.getString("password");
                    String admin = query_result.getString("admin");
                    writer.write("<tr><td>"+id+"</td><td>"+firstname+"</td><td>"+lastname+"</td><td>"+email+"</td><td>"+username+"</td><td>"+password+"</td><td>"+admin+"</td></tr> \n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("5"))
            {
                query_result = statement.executeQuery("SELECT id,name,capital,inhabitants FROM country");
                writer.write("<h2>country - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>name</td><td>capital</td><td>inhabitants</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String name = query_result.getString("name");
                    String capital = query_result.getString("capital");
                    String inhabitants = query_result.getString("inhabitants");
                    writer.write("<tr><td>"+id+"</td><td>"+name+"</td><td>"+capital+"</td><td>"+inhabitants+"</td></tr> \n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("6"))
            {
                query_result = statement.executeQuery("SELECT id,country_id,name,theme FROM destination");
                writer.write("<h2>destination - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>country_id</td><td>name</td><td>theme</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String country_id = query_result.getString("country_id");
                    String name = query_result.getString("name");
                    String theme = query_result.getString("theme");
                    writer.write("<tr><td>"+id+"</td><td>"+country_id+"</td><td>"+name+"</td><td>"+theme+"</td></tr> \n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("7"))
            {
                query_result = statement.executeQuery("SELECT id,destination_id,interest1_id,interest1_id_rating,interest2_id,interest2_id_rating,interest3_id,interest3_id_rating FROM destinationprofiles");
                writer.write("<h2>destinationprofiles - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>destination_id</td><td>interest1_id</td><td>interest1_id_rating</td><td>interest2_id</td><td>interest2_id_rating</td><td>interest3_id</td><td>interest3_id_rating</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String destination_id = query_result.getString("destination_id");
                    String interest1_id = query_result.getString("interest1_id");
                    String interest1_id_rating = query_result.getString("interest1_id_rating");
                    String interest2_id = query_result.getString("interest2_id");
                    String interest2_id_rating = query_result.getString("interest2_id_rating");
                    String interest3_id = query_result.getString("interest3_id");
                    String interest3_id_rating = query_result.getString("interest3_id_rating");
                    writer.write("<tr><td>"+id+"</td><td>"+destination_id+"</td><td>"+interest1_id+"</td><td>"+interest1_id_rating+"</td><td>"+interest2_id+"</td><td>"+interest2_id_rating+"</td><td>"+interest3_id+"</td><td>"+interest3_id_rating+"</td></tr> \n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("8"))
            {
                query_result = statement.executeQuery("SELECT id,hotel_id,comment,generell,room,service,location,gastronomy,sports,user_id FROM evaluations");
                writer.write("<h2>evaluations - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>hotel_id</td><td>comment</td><td>generell</td><td>room</td><td>service</td><td>location</td><td>gastronomy</td><td>sports</td><td>user_id</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String hotel_id = query_result.getString("hotel_id");
                    String comment = query_result.getString("comment");
                    String generell = query_result.getString("generell");
                    String room = query_result.getString("room");
                    String service = query_result.getString("service");
                    String location = query_result.getString("location");
                    String gastronomy = query_result.getString("gastronomy");
                    String sports = query_result.getString("sports");
                    String user_id = query_result.getString("user_id");
                    writer.write("<tr><td>"+id+"</td><td>"+hotel_id+"</td><td>"+comment+"</td><td>"+generell+"</td><td>"+room+"</td><td>"+service+"</td><td>"+location+"</td><td>"+gastronomy+"</td><td>"+sports+"</td><td>"+user_id+"</td></tr> \n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("9"))
            {
                query_result = statement.executeQuery("SELECT id,city_id,name,stars,pension,address,smoker,price,rating FROM hotel");
                writer.write("<h2>hotel - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>city_id</td><td>name</td><td>stars</td><td>pension</td><td>address</td><td>smoker</td><td>price</td><td>rating</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String city_id = query_result.getString("city_id");
                    String name = query_result.getString("name");
                    String stars = query_result.getString("stars");
                    String pension= query_result.getString("pension");
                    String address = query_result.getString("address");
                    String smoker = query_result.getString("smoker");
                    String price = query_result.getString("price");
                    String rating = query_result.getString("rating");
                    writer.write("<tr><td>"+id+"</td><td>"+city_id+"</td><td>"+name+"</td><td>"+stars+"</td><td>"+pension+"</td><td>"+address+"</td><td>"+smoker+"</td><td>"+price+"</td><td>"+rating+"</td></tr> \n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("10"))
            {
                query_result = statement.executeQuery("SELECT id,hotel_id,interest1_id,interest2_id,interest3_id,activity1_id,activity1_id_rating,activity2_id,activity2_id_rating,activity3_id,activity3_id_rating FROM hotelprofiles");
                writer.write("<h2>hotelprofiles - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>hotel_id</td><td>interest1_id</td><td>interest2_id</td><td>interest3_id</td><td>activity1_id</td><td>activity1_id_rating</td><td>activity2_id</td><td>activity2_id_rating</td><td>activity3_id</td><td>activity3_id_rating</td></tr> \n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String hotel_id = query_result.getString("hotel_id");
                    String interest1_id = query_result.getString("interest1_id");
                    String interest2_id = query_result.getString("interest2_id");
                    String interest3_id = query_result.getString("interest3_id");
                    String activity1_id = query_result.getString("activity1_id");
                    String activity1_id_rating = query_result.getString("activity1_id_rating");
                    String activity2_id = query_result.getString("activity2_id");
                    String activity2_id_rating = query_result.getString("activity2_id_rating");
                    String activity3_id = query_result.getString("activity3_id");
                    String activity3_id_rating = query_result.getString("activity3_id_rating");
                    writer.write("<tr><td>"+id+"</td><td>"+hotel_id+"</td><td>"+interest1_id+"</td><td>"+interest2_id+"</td><td>"+interest3_id+"</td><td>"+activity1_id+"</td><td>"+activity1_id_rating+"</td><td>"+activity2_id+"</td><td>"+activity2_id_rating+"</td><td>"+activity3_id+"</td><td>"+activity3_id_rating+"</td></tr> \n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("11"))
            {
                query_result = statement.executeQuery("SELECT id,name FROM interests");
                writer.write("<h2>interests - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>id</td><td>name</td></tr>\n");
                while(query_result.next())
                {
                    String id = query_result.getString("id");
                    String name = query_result.getString("name");
                    writer.write("<tr><td>"+ id +"</td><td>"+ name +"</td></tr>\n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("12"))
            {
                query_result = statement.executeQuery("SELECT user_id, booking_id, hotel, persons, nights, roomtype FROM bookings");
                writer.write("<h2>bookings - table </h2>\n");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>user_id</td><td>booking_id</td><td>hotel</td><td>persons</td><td>nights</td><td>roomtype</td></tr>\n");
                while(query_result.next())
                {
                    String user_id = query_result.getString("user_id");
                    String booking_id = query_result.getString("booking_id");
                    String hotel = query_result.getString("hotel");
                    String persons = query_result.getString("persons");
                    String nights = query_result.getString("nights");
                    String roomtype = query_result.getString("roomtype");
                    writer.write("<tr><td>"+ user_id +"</td><td>"+ booking_id +"</td><td>"+ hotel +"</td><td>"+ persons +"</td><td>"+ nights +"</td><td>"+ roomtype +"</td></tr>\n");
                }
                writer.write("</table> \n");
            }
            if(table.equals("13"))
            {
                query_result = statement.executeQuery("SELECT Id,UserId,Interest1_id,Interest1_rating,Interest2_id,Interest2_rating,Interest3_id,Interest3_rating,Activity1_id,Activity1_rating,Activity2_id,Activity2_rating,Activity3_id,Activity3_rating FROM profiles");
                writer.write("<table border = 1> \n");
                writer.write("<tr><td>Id</td><td>UserId</td><td>Interest1_id</td><td>Interest1_rating</td><td>Interest2_id</td><td>Interest2_rating</td><td>Interest3_id</td><td>Interest3_rating</td><td>Activity1_id</td><td>Activity1_rating</td><td>Activity2_id</td><td>Activity2_rating</td><td>Activity3_id</td><td>Activity3_rating</td></tr> \n");
                while(query_result.next())
                {
                    String Id = query_result.getString("id");
                    String UserId = query_result.getString("UserId");
                    String Interest1_id = query_result.getString("Interest1_id");
                    String Interest1_rating = query_result.getString("Interest1_rating");
                    String Interest2_id = query_result.getString("Interest2_id");
                    String Interest2_rating = query_result.getString("Interest2_rating");
                    String Interest3_id = query_result.getString("Interest3_id");
                    String Interest3_rating = query_result.getString("Interest3_rating");
                    String Activity1_id = query_result.getString("Activity1_id");
                    String Activity1_rating = query_result.getString("Activity1_rating");
                    String Activity2_id = query_result.getString("Activity2_id");
                    String Activity2_rating = query_result.getString("Activity2_rating");
                    String Activity3_id = query_result.getString("Activity3_id");
                    String Activity3_rating = query_result.getString("Activity3_rating");
                    writer.write("<tr><td>"+Id+"</td><td>"+UserId+"</td><td>"+Interest1_id+"</td><td>"+Interest1_rating+"</td><td>"+Interest2_id+"</td><td>"+Interest2_rating+"</td><td>"+Interest3_id+"</td><td>"+Interest3_rating+"</td><td>"+Activity1_id+"</td><td>"+Activity1_rating+"</td><td>"+Activity2_id+"</td><td>"+Activity2_rating+"</td><td>"+Activity3_id+"</td><td>"+Activity3_rating+"</td></tr> \n");
                }
                writer.write("</table> \n");
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
        printMsg("Database error!", writer, request);
      }

      writer.write("<br><br><br>\n");
      writer.write("</fieldset>\n");
      writer.write("</div>\n");
      writer.write("<div id=\"footer\">\n");
      writer.write("<hr />\n");
      writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> |\n");
      writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>\n");
      writer.write("</p>\n");
      writer.write("</div>\n");

      writer.write("</body>\n");
      writer.write("</html>\n");
      
  }

  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h2 style=\"clear: left;\">" + msg + "</h2>\n");
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