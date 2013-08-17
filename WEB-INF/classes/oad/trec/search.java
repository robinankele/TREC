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

public class search extends HttpServlet{

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
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 950px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");
    writer.write("<div id=\"searchoutput\">\n");

    int no_country = 0;
    int no_destination = 0;
    int no_city = 0;
    String country = request.getParameter("country");
    if((country == null) || (country.length() == 0))
    {
        no_country = 1;
    }

    String destination = request.getParameter("destination");
    if((destination == null) || (destination.length() == 0))
    {
        no_destination = 1;
    }

    String city = request.getParameter("city");
    if((city == null) || (city.length() == 0))
    {
        no_city = 1;
    }

    int arrivaldateday = Integer.parseInt(request.getParameter("arrivaldateday"));
    String arrivaldatemonth = request.getParameter("arrivaldatemonth");
    int departuredateday = Integer.parseInt(request.getParameter("departuredateday"));
    String departuredatemonth = request.getParameter("departuredatemonth");
    int travellers = Integer.parseInt(request.getParameter("travellers"));

    
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
          if((no_country == 1) && (no_destination == 1) && (no_city == 1))  // liste alle hotels auf
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating FROM hotel WHERE 1");
            no_country = 2;
            no_destination = 2;
            no_city = 2;
          }
          else if(no_destination == 1 && no_city == 1) // liste alle hotels in einem Land auf
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating FROM hotel, country, citys WHERE hotel.city_id = citys.id AND citys.country_id = country.id AND country.name = '"+ country +"'");
            no_destination = 2;
            no_city = 2;
          }
          else if(no_city == 1) //  liste alle hotels in einer Destination auf
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating FROM hotel, citys, destination WHERE hotel.city_id = citys.id AND citys.destination_id = destination.id AND destination.name = '" + destination +"'");
            no_city = 2;
          }
          else if((no_country == 0 && no_destination == 0 && no_city == 0) || (no_city == 0 && no_country == 1 && no_destination == 1) || (no_city == 0 && no_country == 1 && no_destination == 0) || (no_city == 0 && no_country == 0 && no_destination == 1))//  liste alle hotels in einer City auf
          {
            query_result = statement.executeQuery("SELECT hotel.id, hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating FROM hotel, citys WHERE hotel.city_id = citys.id AND citys.city = '"+ city +"'");
            no_country = 2;
            no_destination = 2;
            no_city = 2;
          }
          else
          {
              printMsg("No Hotel found! Please try again", writer, request);
          }
          writer.write("<br>\n");
          while(query_result.next())
          {
            String rating = " ";
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

            writer.write("<fieldset style=\"width:550px; height:170px; margin-left: 200px; background-image:url(output.png);\">");
            writer.write("<table style=\"margin-top:10px; margin-left:10px;\">\n");
            writer.write("<tr><td style=\"width: 400px\">\n");
            writer.write("<p style=\"font-size:30; font:calibri;\"><b>"+hotel_name+"</b></p>\n");
            writer.write("<td><p style=\"font-size:25; font:calibri;\"><i>"+ rating +"</i></p></td>\n");
            writer.write("</td></tr><tr><td><p style=\"font-size:17; font:calibri;\">"+ hotel_address +"</p></td></tr>\n");
            writer.write("<tr><td><p style=\"font-size:17; font:calibri;\">pension: <i>"+ hotel_half_full_pension +"</i>  |  smoker: <i>"+ hotel_smoker_nonsmoker +"</i> | stars: <i>"+ hotel_stars +"</i>  | price: <i>"+ hotel_price +"</i> &euro;</p></td>\n");
            writer.write("</tr>\n");
            writer.write("<td>\n");
            writer.write("<form action=\"specifiedoutputpage\" method=\"GET\">\n");
            writer.write("<input type =\"hidden\" name = \"country\" value =\"" + country + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"destination\" value =\"" + destination + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"city\" value =\"" + city + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"arrivaldateday\" value =\"" + arrivaldateday + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"arrivaldatemonth\" value =\"" + arrivaldatemonth + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"departuredateday\" value =\"" + departuredateday + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"departuredatemonth\" value =\"" + departuredatemonth + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"travellers\" value =\"" + travellers + "\"/>\n");
            writer.write("<input type =\"hidden\" name = \"hotel_id\" value =\"" + hotel_id + "\"/>\n");
            writer.write("<input style=\"margin-left: 300px\" type =\"submit\" value =\"Details\"/>\n");
            writer.write("</form></td><td>\n");
            writer.write("<form action=\"searchpage\" method=\"GET\">\n");
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
