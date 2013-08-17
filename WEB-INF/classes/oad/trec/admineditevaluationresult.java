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

public class admineditevaluationresult extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    HttpSession sess = request.getSession(true);
    if(sess.getValue("user") != null)
    {
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
        writer.write("<h2>Kommentar zum Hotel:</h2>\n");
        writer.write("<form action=\"admineditevaluationdatabase\" method=\"GET\" style=\"float: left;\">\n");

        String evaluation_comment = request.getParameter("evaluation_comment");

        writer.write("<p> <textarea name=\"user_comment\" cols=\"50\" rows=\"7\">"+evaluation_comment+"</textarea></p>\n");
        writer.write("<h2>Bewertung der Teilbereiche in Sternen von 0 - 6:</h2>\n");
        writer.write("<p>\n");
        writer.write("<table border=\"0\">\n");
        writer.write("<colgroup width=\"50%\" span=\"2\"></colgroup>");
        writer.write("<tr>\n");
        writer.write("<th>Teilbereich</th>\n");
        writer.write("<th>0 &nbsp 1 &nbsp&nbsp 2 &nbsp&nbsp 3 &nbsp&nbsp 4 &nbsp&nbsp 5 &nbsp 6</th>\n");
        writer.write("</tr>\n");
        writer.write("<td>Hotel Generally</td>\n");
        writer.write("<td>\n");

        int evaluation_generell = Integer.parseInt(request.getParameter("evaluation_generell"));
        if(evaluation_generell == 0)
          editbutton(0, "HotelAllgemein", writer);
        if(evaluation_generell == 1)
          editbutton(1, "HotelAllgemein", writer);
        if(evaluation_generell == 2)
          editbutton(2, "HotelAllgemein", writer);
        if(evaluation_generell == 3)
          editbutton(3, "HotelAllgemein", writer);
        if(evaluation_generell == 4)
          editbutton(4, "HotelAllgemein", writer);
        if(evaluation_generell == 5)
          editbutton(5, "HotelAllgemein", writer);
        if(evaluation_generell == 6)
          editbutton(6, "HotelAllgemein", writer);

        writer.write("</td>\n");
        writer.write("</tr>\n");

        writer.write("<tr>\n");
        writer.write("<td>Zimmer</td>\n");
        writer.write("<td>\n");

        int evaluation_room = Integer.parseInt(request.getParameter("evaluation_room"));
        if(evaluation_room == 0)
          editbutton(0, "Zimmer", writer);
        if(evaluation_room == 1)
          editbutton(1, "Zimmer", writer);
        if(evaluation_room == 2)
          editbutton(2, "Zimmer", writer);
        if(evaluation_room == 3)
          editbutton(3, "Zimmer", writer);;
        if(evaluation_room == 4)
          editbutton(4, "Zimmer", writer);
        if(evaluation_room == 5)
          editbutton(5, "Zimmer", writer);
        if(evaluation_room == 6)
          editbutton(6, "Zimmer", writer);

        writer.write("</td>\n");
        writer.write("</tr>\n");

        writer.write("<tr>\n");
        writer.write("<td>Service</td>\n");
        writer.write("<td>\n");

        int evaluation_service = Integer.parseInt(request.getParameter("evaluation_service"));
        if(evaluation_service == 0)
          editbutton(0, "Service", writer);
        if(evaluation_service == 1)
          editbutton(1, "Service", writer);
        if(evaluation_service == 2)
          editbutton(2, "Service", writer);
        if(evaluation_service == 3)
          editbutton(3, "Service", writer);
        if(evaluation_service == 4)
          editbutton(4, "Service", writer);
        if(evaluation_service == 5)
          editbutton(5, "Service", writer);
        if(evaluation_service == 6)
          editbutton(6, "Service", writer);

        writer.write("</td>\n");
        writer.write("</tr>\n");

        writer.write("<tr>\n");
        writer.write("<td>Lage</td>\n");
        writer.write("<td>\n");

        int evaluation_location = Integer.parseInt(request.getParameter("evaluation_location"));
        if(evaluation_location == 0)
          editbutton(0, "Lage", writer);
        if(evaluation_location == 1)
          editbutton(1, "Lage", writer);
        if(evaluation_location == 2)
          editbutton(2, "Lage", writer);
        if(evaluation_location == 3)
          editbutton(3, "Lage", writer);
        if(evaluation_location == 4)
          editbutton(4, "Lage", writer);
        if(evaluation_location == 5)
          editbutton(5, "Lage", writer);
        if(evaluation_location == 6)
          editbutton(6, "Lage", writer);

        writer.write("</td>\n");
        writer.write("</tr>\n");

        writer.write("<tr>\n");
        writer.write("<td>Gastronomie</td>\n");
        writer.write("<td>\n");

        int evaluation_gastronomy = Integer.parseInt(request.getParameter("evaluation_gastronomy"));
        if(evaluation_gastronomy == 0)
          editbutton(0, "Gastronomie", writer);
        if(evaluation_gastronomy == 1)
          editbutton(1, "Gastronomie", writer);
        if(evaluation_gastronomy == 2)
          editbutton(2, "Gastronomie", writer);
        if(evaluation_gastronomy == 3)
          editbutton(3, "Gastronomie", writer);;
        if(evaluation_gastronomy == 4)
          editbutton(4, "Gastronomie", writer);
        if(evaluation_gastronomy == 5)
          editbutton(5, "Gastronomie", writer);
        if(evaluation_gastronomy == 6)
          editbutton(6, "Gastronomie", writer);

        writer.write("</td>\n");
        writer.write("</tr>\n");

        writer.write("<tr>\n");
        writer.write("<td>Sport und Unterhaltung</td>\n");
        writer.write("<td>\n");

        int evaluation_sports = Integer.parseInt(request.getParameter("evaluation_sports"));
        if(evaluation_sports == 0)
          editbutton(0, "Sport und Unterhaltung", writer);
        if(evaluation_sports == 1)
          editbutton(1, "Sport und Unterhaltung", writer);
        if(evaluation_sports == 2)
          editbutton(2, "Sport und Unterhaltung", writer);
        if(evaluation_sports == 3)
          editbutton(3, "Sport und Unterhaltung", writer);
        if(evaluation_sports == 4)
          editbutton(4, "Sport und Unterhaltung", writer);
        if(evaluation_sports == 5)
          editbutton(5, "Sport und Unterhaltung", writer);
        if(evaluation_sports == 6)
          editbutton(6, "Sport und Unterhaltung", writer);

        writer.write("</td>\n");
        writer.write("</tr>\n");
        writer.write("</table>\n");

        int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
        int evaluate_id = Integer.parseInt(request.getParameter("evaluate_id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        writer.write("<input type =\"hidden\" name =\"user_id\" value =\""+user_id+"\"/>\n");
        writer.write("<input type =\"hidden\" name =\"evaluate_id\" value =\""+evaluate_id+"\"/>\n");
        writer.write("<input type =\"hidden\" name =\"hotel_id\" value =\""+hotel_id+"\"/>\n");
        writer.write("<p><input type =\"submit\" value =\"Edit\"/></p>\n");
        writer.write("</form>\n");
        writer.write("</fieldset>\n");
        writer.write("</div>\n");
        printMsg("", writer, request);
    }
    else
    {
    response.sendRedirect(""+"index.html");
    }

  }

    private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));

    writer.write("<h1 style=\"clear: left;\">" + msg + "</h1>\n");
    writer.write("<form action=\"adminevaluationresult\" method=\"GET\">\n");
    writer.write("<input type =\"hidden\" name =\"evaluate_hotel_id\" value =\""+hotel_id+"\"/>\n");
    writer.write("<input style=\"margin-left: 800px;\" type =\"submit\" value =\"Back\"/>\n");
    writer.write("</form></td>\n");
    writer.write("<hr/>\n");
    writer.write("<div id=\"footer\">\n");
    writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | \n");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>\n");
    writer.write("</p>\n");
    writer.write("</div>\n");
    writer.write("</body>\n");
    writer.write("</html>\n");

  }
    private void editbutton(int select, String name, PrintWriter writer){
    int count = 0;

        for (count = 0; count <= 6; count++)
        {
          if(select == count)
            writer.write("<input type=\"radio\" name=\""+name+"\" value=\""+count+"\" checked>\n");
          else
            writer.write("<input type=\"radio\" name=\""+name+"\" value=\""+count+"\">\n");
        }

    
  }
}
