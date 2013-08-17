package oad.trec;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class admindatabasepage extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    HttpSession sess = request.getSession(true);
    if(sess.getValue("user") != null)
    {
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
      writer.write("<form action=\"mainpage\" method=\"GET\">\n");
      writer.write("<td><input style=\"margin-left:50px\" type =\"submit\" value =\"Cancel\"/></td>\n");
      writer.write("</tr></table>\n");
      writer.write("</form>\n");
      writer.write("<h2>Database:</h2>\n");
      writer.write("<table><tr>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"activeuser\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"1\"/>\n");
      writer.write("</form></td>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"activities\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"2\"/>\n");
      writer.write("</form></td>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"citys\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"3\"/>\n");
      writer.write("</form></td>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"user\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"4\"/>\n");
      writer.write("</form></td>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"country\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"5\"/>\n");
      writer.write("</form></td></tr><tr>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"destination\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"6\"/>\n");
      writer.write("</form></td>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"destinationprofiles\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"7\"/>\n");
      writer.write("</form></td>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"evaluations\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"8\"/>\n");
      writer.write("</form></td>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"hotel\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"9\"/>\n");
      writer.write("</form></td>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"hotelprofiles\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"10\"/>\n");
      writer.write("</form></td></tr><tr>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"interests\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"11\"/>\n");
      writer.write("</form></td>\n");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"bookings\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"12\"/>\n");
      writer.write("</form></td>");
      writer.write("<td><form action=\"admindatabaselistdb\" method=\"GET\">\n");
      writer.write("<input style=\"height: 25px; width: 150px\" type =\"submit\" value =\"profiles\"/>\n");
      writer.write("<input type =\"hidden\" name = \"table\" value =\"13\"/>\n");
      writer.write("</form></td></tr></table>\n");
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
    else
    {
       response.sendRedirect(""+"index.html");
    }
  }
  
}