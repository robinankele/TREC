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

public class getStatistic extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>OutputPage</title>\n");
    writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
    writer.write("</head>\n");
    writer.write("<body>\n");
    writer.write("<div id=\"header\" align = \"center\"\n>");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>\n");
    writer.write("</div>\n");
    writer.write("<div id=\"socialNetworkBox\">\n");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>\n");
    writer.write("</div>\n");
    writer.write("<div id=\"searchoutput\">\n");
    
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
      ResultSet query_result = null;
      String destination = request.getParameter("destination");
      int check_admin = 0;
      String admin = null;
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          admin = ((user)sess.getValue("user")).getAdmin();
          if(admin.equals("1"))
            check_admin = 1;
      }
      else
      {
        response.sendRedirect(""+"index.html");
        printMsg("Username or password false!", writer, request);
        return;
      }

      for(int count = 1; count < 11; count++)
      {
          if(count == 1)
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating FROM hotel GROUP BY hotel.price ORDER BY MAX(hotel.price) LIMIT 0,5");     //5 cheapest hotels
            writer.write("<h3>5 Cheapest Hotels: </h3>\n");
          }
          if(count == 2)
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating FROM hotel GROUP BY hotel.price ORDER BY MAX(hotel.price) DESC LIMIT 0,3");     //3 most expensive hotels
            writer.write("<h3>3 Most expensive Hotels: </h3>\n");
          }
          if(count == 3  && check_admin == 1)
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating, evaluations.hotel_id FROM hotel, evaluations WHERE hotel.id = evaluations.hotel_id GROUP BY evaluations.hotel_id ORDER BY COUNT(evaluations.hotel_id) DESC LIMIT 0,5");     //5 hotels with highest number of customer evaluations
            writer.write("<h3>5 Hotels with highest number of Customer Evaluations: </h3>\n");
          }
          if(count == 4)
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating, evaluations.hotel_id FROM hotel, evaluations WHERE hotel.id = evaluations.hotel_id GROUP BY evaluations.hotel_id ORDER BY AVG(evaluations.generell + evaluations.room) DESC LIMIT 0,5");     //5 hotels with best overall evaluation
            writer.write("<h3>5 Hotels with best overall Evaluations: </h3>\n");}
          if(count == 5 && check_admin == 1)
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating, evaluations.hotel_id FROM hotel, evaluations WHERE hotel.id = evaluations.hotel_id GROUP BY evaluations.hotel_id ORDER BY AVG(evaluations.generell + evaluations.room) LIMIT 0,5");     //5 hotels worst overall evaluation
            writer.write("<h3>5 Hotels with worst overall Evaluations: </h3>\n");
          }
          if(count == 6)
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating FROM hotel, destination, citys WHERE hotel.city_id = citys.id  AND citys.destination_id = destination.id AND destination.name = '"+destination+"' GROUP BY hotel.price ORDER BY MAX(hotel.price) DESC LIMIT 0,3");     //3 most expensive hotels selected by destination
            writer.write("<h3>3 most expensive Hotels selected by Destination: "+destination+"</h3>\n");
          }
          if(count == 7  && check_admin == 1)
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating, evaluations.hotel_id FROM hotel,destination, citys, evaluations WHERE hotel.id = evaluations.hotel_id AND hotel.city_id = citys.id  AND citys.destination_id = destination.id AND destination.name = '"+destination+"' GROUP BY evaluations.hotel_id ORDER BY COUNT(evaluations.hotel_id) DESC LIMIT 0,5");     //5 hotels with highest number of customer evaluations by destination
            writer.write("<h3>5 Hotels with highest number of Customer Evaluations by Destination: "+destination+" </h3>\n");
          }
          if (count == 8 && check_admin == 1)
          {
            query_result = statement.executeQuery("SELECT user.Id, user.FirstName, user.LastName, user.Email, user.username FROM user, evaluations WHERE user.Id = evaluations.user_id GROUP BY user.Id ORDER BY COUNT(evaluations.user_id) DESC LIMIT 0,3");     //3 customer with highest number of evaluations
            writer.write("<h3>3 Customers with highest number of Evaluations: </h3>\n");
          }
          if (count == 9 && check_admin == 1)
          {
            query_result = statement.executeQuery("SELECT user.Id, user.FirstName, user.LastName, user.Email, user.username FROM user, evaluations WHERE user.Id = evaluations.user_id GROUP BY user.Id ORDER BY COUNT(evaluations.user_id) LIMIT 0,3");     //3 customer with lowest number of evaluation
            writer.write("<h3>3 Customers with lowest number of Evaluations: </h3>\n");
          }
          if (count == 10 && check_admin == 1)
          {
            query_result = statement.executeQuery("SELECT user.ID, user.FirstName, user.LastName, user.Email, user.username, interests.name FROM destination, profiles, interests, user WHERE user.Id = profiles.UserId AND ((profiles.Interest1_id = destination.theme) OR (profiles.Interest1_id = destination.theme) OR (profiles.Interest1_id = destination.theme)) AND destination.theme = interests.id GROUP BY user.ID");     // All customers with interest in destination supporting specifeidinterest themes
            writer.write("<h3>All customers which are interested in destinations supporting specified interrest themes: </h3>\n");
          }
          if (count == 11)
          {
            query_result = statement.executeQuery("SELECT destination.name, interests.name FROM destination, interests WHERE destination.theme = interests.id GROUP BY destination.name");     // Destinations supporting specifeidinterest themes
            writer.write("<h3>All Destinations which support specified interest themes </h3>\n");
          }

          writer.write("<br>\n");

          while(query_result.next())
          {
            if(count <= 7)
            {
                String rating = null;
                String hotel_name = query_result.getString("name");
                String hotel_address = query_result.getString("address");
                int hotel_stars = Integer.parseInt(query_result.getString("stars"));
                String hotel_half_full_pension = query_result.getString("pension");
                String hotel_smoker_nonsmoker = query_result.getString("smoker");
                int hotel_price = Integer.parseInt(query_result.getString("price"));
                int hotel_customer_ratings = Integer.parseInt(query_result.getString("rating"));
                int hotel_id = Integer.parseInt(query_result.getString("id"));
                if(hotel_half_full_pension.equals("both"))
                    hotel_half_full_pension ="half/full";
                if(hotel_smoker_nonsmoker.equals("0"))
                    hotel_smoker_nonsmoker ="no";
                else
                    hotel_smoker_nonsmoker ="yes";
               if(hotel_customer_ratings > 0)
                   rating = "Nicht bewertet";
               if(hotel_customer_ratings > 2)
                    rating = "Genügend";
                if(hotel_customer_ratings > 4)
                    rating = "Befriedigend";
                if(hotel_customer_ratings > 6)
                    rating = "Gut";
                if(hotel_customer_ratings > 8)
                    rating = "Sehr Gut";

                writer.write("<fieldset style=\"width:500px; height:170px; margin-left: 200px; background-image:url(output.png);\">");

                writer.write("<table style=\"margin-top:10px; margin-left:10px;\">\n");
                writer.write("<tr><td style=\"width: 350px\">\n");
                writer.write("<p style=\"font-size:30; font:calibri;\"><b>"+hotel_name+"</b></p>\n");
                writer.write("<td><p style=\"font-size:25; font:calibri;\"><i>"+ rating +"</i></p></td>\n");
                writer.write("</td></tr><tr><td><p style=\"font-size:17; font:calibri;\">"+ hotel_address +"</p></td></tr>\n");
                writer.write("<tr><td><p style=\"font-size:17; font:calibri;\">pension: <i>"+ hotel_half_full_pension +"</i>  |  smoker: <i>"+ hotel_smoker_nonsmoker +"</i> | stars: <i>"+ hotel_stars +"</i>  | price: <i>"+ hotel_price +"</i> &euro;</p></td>\n");
                writer.write("</tr></table>\n");
                writer.write("</fieldset>");
            }
            if(count >= 8 && count <= 9)
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
            if(count == 10)
            {
                int user_id = Integer.parseInt(query_result.getString("user.Id"));
                String firstname = query_result.getString("user.FirstName");
                String lastname = query_result.getString("user.LastName");
                String email = query_result.getString("user.Email");
                String username = query_result.getString("user.username");
                String interest = query_result.getString("interests.name");
                writer.write("<fieldset style=\"width:500px; height:60px; margin-left: 200px; background-image:url(output.png);\">");
                writer.write("<table style=\"margin-top:10px; margin-left:10px;\">\n");
                writer.write("<tr><td style=\"width: 350px\">\n");
                writer.write("<tr><td><p style=\"font-size:17; font:calibri;\">user_id: <i>"+ user_id +"</i> |  firstname: <i>"+ firstname +"</i>  |  lastname: <i>"+ lastname +"</i> | email: <i>"+ email +"</i>  | username: <i>"+ username +"</i>| interest: <i>"+ interest +"</i></p></td>\n");
                writer.write("</tr></table>\n");
                writer.write("</fieldset>");
            }
            if(count == 11)
            {
                String interest_name = query_result.getString("interests.name");
                String destination_name = query_result.getString("destination.name");
                writer.write("<fieldset style=\"width:500px; height:170px; margin-left: 200px; background-image:url(output.png);\">");
                writer.write("<table style=\"margin-top:10px; margin-left:10px;\">\n");
                writer.write("<tr><td style=\"width: 350px\">\n");
                writer.write("<tr><td><p style=\"font-size:17; font:calibri;\">Destination: <i>"+ destination_name +"</i> |  Interest: <i>"+ interest_name +"</i></p></td>\n");
                writer.write("</tr></table>\n");
                writer.write("</fieldset>");
            }
            writer.write("<br>");
          }
        }
      writer.write("<form action=\"mainpage\" method=\"GET\">\n");
      writer.write("<p><input style=\"margin-left: 0px\"type =\"submit\" value =\"Back\"/></p>\n");
      writer.write("</form>\n");
      writer.write("</div>");
      printMsg("", writer, request);
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("database error!", writer, request);
    }
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
