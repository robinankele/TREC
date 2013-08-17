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

public class specifiedoutputpage extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>SpecifiedOutputPage</title>\n");
    writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
    writer.write("</head>\n");
    writer.write("<body>\n");
    writer.write("<div id=\"header\" align = \"center\"\n>");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>\n");
    writer.write("</div>\n");
    writer.write("<div id=\"socialNetworkBox\">\n");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>\n");
    writer.write("</div>\n");
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 950px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");
    writer.write("<div id=\"specifiedoutputpage\">\n");

    String country = request.getParameter("country");
    String destination = request.getParameter("destination");
    String city = request.getParameter("city");

    int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
    int travellers = Integer.parseInt(request.getParameter("travellers"));
    int arrivaldateday = Integer.parseInt(request.getParameter("arrivaldateday"));
    String arrivaldatemonth = request.getParameter("arrivaldatemonth");
    int departuredateday = Integer.parseInt(request.getParameter("departuredateday"));
    String departuredatemonth = request.getParameter("departuredatemonth");
    
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
          query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating FROM hotel WHERE hotel.id = " + hotel_id + "");


          writer.write("<br>\n");
          writer.write("<div id=\"searchoutput\">");
          writer.write("<br>\n");
          writer.write("<br>\n");
          while(query_result.next())
          {
            String rating = null;
            String hotel_name = query_result.getString("name");
            String hotel_address = query_result.getString("address");
            int hotel_stars = Integer.parseInt(query_result.getString("stars"));
            String hotel_half_full_pension = query_result.getString("pension");
            String hotel_smoker_nonsmoker = query_result.getString("smoker");
            int hotel_price = Integer.parseInt(query_result.getString("price"));
            int hotel_customer_ratings = Integer.parseInt(query_result.getString("rating"));
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

            writer.write("<fieldset style=\"width:600px; height:250px; margin-left: 200px; background-image:url(output_spec.png);\">");
            writer.write("<table style=\"margin-top:10px; margin-left:10px;\">\n");
            writer.write("<tr><td style=\"width: 400px\">\n");
            writer.write("<p style=\"font-size:30; font:calibri;\"><b>"+hotel_name+"</b></p>\n");
            writer.write("<td><p style=\"font-size:25; font:calibri;\"><i>"+ rating +" ("+hotel_customer_ratings+")</i></p></td>\n");
            writer.write("</td></tr><tr><td><p style=\"font-size:17; font:calibri;\">"+ hotel_address +"</p></td></tr>\n");
            writer.write("<tr><td><p style=\"font-size:17; font:calibri;\">pension: <i>"+ hotel_half_full_pension +"</i>  |  smoker: <i>"+ hotel_smoker_nonsmoker +"</i>  | stars: <i>"+ hotel_stars +"</i> |   price: <i>"+ hotel_price +"</i> &euro;</p></td>\n");
            writer.write("</tr><tr><td><p style=\"font-size:17; font:calibri;\"><i>More Information:</i></p><td></tr>\n");
            writer.write("<tr><td><p style=\"font-size:17; font:calibri;\">interest-themes: \n");
            try
            {
              connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
              statement = connection.createStatement();
              query_result = null;
              int hotel_id_select = Integer.parseInt(request.getParameter("hotel_id"));
              int count = 1;
              while(count<4)
              {
                query_result = statement.executeQuery("SELECT interests.name from interests, hotelprofiles where hotelprofiles.interest"+count+"_id = interests.id and hotelprofiles.hotel_id = "+hotel_id_select+"");
                count++;
                  while(query_result.next())
                  {
                    String interest = query_result.getString("interests.name");
                    writer.write("<i>"+ interest +"</i>  | \n");
                  }
               }
            }
            catch(SQLException exc)
            {
              exc.printStackTrace();
            }

            writer.write("</p></td></tr><tr><td><p style=\"font-size:17; font:calibri;\">activities: \n");
            try
            {
              connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
              statement = connection.createStatement();
              query_result = null;
              int hotel_id_select = Integer.parseInt(request.getParameter("hotel_id"));
              int count = 1;
              while(count<4)
              {
                query_result = statement.executeQuery("SELECT activities.name from activities, hotelprofiles where hotelprofiles.activity"+count+"_id = activities.id and hotelprofiles.hotel_id = "+hotel_id_select+"");
                count++;
                  while(query_result.next())
                  {
                    String activities = query_result.getString("activities.name");
                    writer.write("<i>"+ activities +"</i>  | \n");
                  }
               }
            }
            catch(SQLException exc)
            {
              exc.printStackTrace();
            }
            writer.write("</p></td></tr><td>\n");
            writer.write("<form action=\"bookingpage\" method=\"GET\">\n");
            if(country != null && !country.equals("null"))
              writer.write("<input type =\"hidden\" name = \"country\" value =\"" + country + "\"/>\n");
            if(destination != null && !destination.equals("null"))
              writer.write("<input type =\"hidden\" name = \"destination\" value =\"" + destination + "\"/>\n");
            if(city != null && !city.equals("null"))
              writer.write("<input type =\"hidden\" name = \"city\" value =\"" + city + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"arrivaldateday\" value =\"" + arrivaldateday + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"arrivaldatemonth\" value =\"" + arrivaldatemonth + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"departuredateday\" value =\"" + departuredateday + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"departuredatemonth\" value =\"" + departuredatemonth + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"travellers\" value =\"" + travellers + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"hotel_id\" value =\"" + hotel_id + "\"/>\n");
            writer.write("<input style=\"margin-left: 360px\" type =\"submit\" value =\"Book Hotel\"/>\n");
            writer.write("</form></td><td>\n");
            writer.write("<form action=\"search\" method=\"GET\">\n");
            if(country != null && !country.equals("null"))
              writer.write("<input type =\"hidden\" name = \"country\" value =\"" + country + "\"/>\n");
            if(destination != null && !destination.equals("null"))
              writer.write("<input type =\"hidden\" name = \"destination\" value =\"" + destination + "\"/>\n");
            if(city != null && !city.equals("null"))
              writer.write("<input type =\"hidden\" name = \"city\" value =\"" + city + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"arrivaldateday\" value =\"" + arrivaldateday + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"arrivaldatemonth\" value =\"" + arrivaldatemonth + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"departuredateday\" value =\"" + departuredateday + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"departuredatemonth\" value =\"" + departuredatemonth + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"travellers\" value =\"" + travellers + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"hotel_id\" value =\"" + hotel_id + "\"/>\n");
            writer.write("<input style=\"margin-left: 10px\"type =\"submit\" value =\"Back\"/>\n");
            writer.write("</form></td></table>\n");
            writer.write("</fieldset>");
            writer.write("<br>");
            writer.write("<br>");
          }
          writer.write("</div>");
          printMsg("", writer, request);
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
