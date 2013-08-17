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

public class gethotels extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\"\n");
    writer.write("\"http://www.w3.org/TR/RBC-html40/loose.dtd\">\n");
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>gethotels</title>\n");
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"main.css\" />\n");
    writer.write("</head>\n");
    writer.write("<body>\n");
    writer.write("<div id=\"header\">\n");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\" />\n");
    writer.write("</div>\n");
    writer.write("<div id=\"socialNetworkBox\">\n");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>\n");
    writer.write("</div>\n");
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 950px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");


    String destination = request.getParameter("destination");
    if((destination == null) || (destination.length() == 0))
    {
        printMsg("You have no destination selected!",writer,request);
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
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          int user_id = 1;
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
          Statement statement = connection.createStatement();
          ResultSet query_result = statement.executeQuery("SELECT hotel.name, hotel.stars, hotel.pension, hotel.address, hotel.smoker, hotel.price, hotel.rating FROM hotel, citys, destination, hotelprofiles WHERE hotel.city_id = citys.id AND citys.destination_id = destination.id AND destination.name = '"+destination+"' AND hotelprofiles.hotel_id = hotel.id ORDER BY ABS(ABS(hotelprofiles.activity1_id_rating + hotelprofiles.activity2_id_rating + hotelprofiles.activity3_id_rating)-(SELECT SUM(profiles.Activity1_id + profiles.Activity2_id + profiles.Activity3_id) FROM user, profiles WHERE profiles.UserID = user.id AND user.Id = "+user_id+")) ASC LIMIT 0,3");

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

            writer.write("<fieldset style=\"width:500px; height:170px; margin-left: 300px; background-image:url(output.png);\">");
            writer.write("<table style=\"margin-top:10px; margin-left:10px;\">\n");
            writer.write("<tr><td style=\"width: 350px\">\n");
            writer.write("<p style=\"font-size:30; font:calibri;\"><b>"+hotel_name+"</b></p>\n");
            writer.write("<td><p style=\"font-size:25; font:calibri;\"><i>"+ rating +"</i></p></td>\n");
            writer.write("</td></tr><tr><td><p style=\"font-size:17; font:calibri;\">"+ hotel_address +"</p></td></tr>\n");
            writer.write("<tr><td><p style=\"font-size:17; font:calibri;\">pension: <i>"+ hotel_half_full_pension +"</i>  |  smoker: <i>"+ hotel_smoker_nonsmoker +"</i> | stars: <i>"+ hotel_stars +"</i>  | price: <i>"+ hotel_price +"</i> &euro;</p></td>\n");
            writer.write("</tr></table>\n");
            writer.write("</fieldset>");
            writer.write("<br>");
            writer.write("<br>");
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
      printMsg("database error!", writer, request);
    }
    printMsg("", writer, request);
  }

  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<form action=\"getrecommendationpage\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 10px\"type =\"submit\" value =\"Back\"/>\n");
    writer.write("</form>\n");
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
