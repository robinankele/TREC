package oad.trec;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class impressum extends HttpServlet{

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

writer.write("<div id = \"impressum\">\n");
writer.write("<h1> Impressum </h1>\n");
writer.write("<p> Programmers:</p>\n");
writer.write("<table>\n");

writer.write("<tr><td>\n");
writer.write("<p> Ralph Ankele</td><td><a href=\"mailto:ralph.ankele@root.tugraz.at\">mailto: ralph.ankele</a></td></p>\n");
writer.write("</tr><tr><td>\n");
writer.write("<p>Robin Ankele</td><td><a href=\"mailto:robin.ankele@root.tugraz.at\">mailto: robin.ankele</a></td></p>\n");
writer.write("</tr><tr><td>\n");
writer.write("<p> M�sl�m Atas</td><td><a href=\"mailto:muesluem.atas@root.tugraz.at\">mailto: muesluem.atas</a></td></p>\n");
writer.write("</tr><tr><td>\n");
writer.write("<p> Christopher Pail</td><td><a href=\"mailto:christopher.pail@root.tugraz.at\">mailto: christopher.pail</a></td></p>\n");
writer.write("</tr><tr><td>\n");
writer.write("<p> Raphael Sommer</td><td><a href=\"mailto:raphael.sommer@root.tugraz.at\">mailto: raphael.sommer</a></td></p>\n");
writer.write("</tr>\n");
writer.write("<tr><td><pre>                                </td></pre></tr></table>\n");
writer.write("<pre>\n");

writer.write("</pre>\n");
writer.write("<p> Header Graphic from elreviae</p>\n");
writer.write("</div>\n");
   writer.write("<div id=\"facebook\">\n");
writer.write("<p align = \"center\">\n");
writer.write("<a href=\"http://www.facebook.com/pages/TREC/139183509474395\">\n");
writer.write("<img align = \"center\" src = \"logo.png\"></img></a></p>\n");
writer.write("<p align = \"center\">Oder besuchen Sie uns Auf Facebook</p>\n");
    writer.write("</div>\n");
 writer.write("<div id=\"footer\">\n");
    writer.write("<hr />\n");
      writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | \n");
          writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>\n");
      writer.write("</p>\n");
  writer.write("</div>\n");
  writer.write("</body>\n");
  writer.write("</html>\n");

}
}
