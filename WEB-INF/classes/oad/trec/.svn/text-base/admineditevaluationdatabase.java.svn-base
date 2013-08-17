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

public class admineditevaluationdatabase extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>Admin Evaluation</title>\n");
    writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
    writer.write("</head>");
    writer.write("<body>");
    writer.write("<div id=\"header\" align = \"center\">");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>");
    writer.write("</div>");
    writer.write("<div id=\"socialNetworkBox\">");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>");
    writer.write("</div>\n");
    writer.write("<div id=\"evaluate\">\n");
    writer.write("<fieldset>\n");
    writer.write("<legend>Hotelbewertung</legend>\n");
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");
    writer.write("<form action=\"adminevaluationresult\" method=\"GET\" style=\"float: left;\">\n");

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
            int evaluate_id = Integer.parseInt(request.getParameter("evaluate_id"));
            String comment = request.getParameter("user_comment");
            int generally = Integer.parseInt(request.getParameter("HotelAllgemein"));
            int rooms = Integer.parseInt(request.getParameter("Zimmer"));
            int service = Integer.parseInt(request.getParameter("Service"));
            int location = Integer.parseInt(request.getParameter("Lage"));
            int gastronomy = Integer.parseInt(request.getParameter("Gastronomie"));
            int sports = Integer.parseInt(request.getParameter("Sport und Unterhaltung"));
            int user_id = Integer.parseInt(request.getParameter("user_id"));
            int hotel_id_update = Integer.parseInt(request.getParameter("hotel_id"));

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate("UPDATE evaluations SET comment = '"+ comment +"', generell = "+ generally +", room = "+rooms+", service = "+service+", location = "+location+", gastronomy = "+gastronomy+", sports = "+sports+" WHERE evaluations.id = "+evaluate_id+" AND evaluations.user_id = "+user_id+" AND evaluations.hotel_id = "+hotel_id_update+"");

            int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
            writer.write("<input type =\"hidden\" name =\"evaluate_hotel_id\" value =\""+hotel_id+"\"/>\n");
            writer.write("<p><input type =\"submit\" value =\"Back\"/></p>\n");
            writer.write("</form>\n");
            writer.write("</fieldset>\n");
            writer.write("</div>\n");
            printMsg("Succesfully edited Evaluation Entry", writer, request);
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
    int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));

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
