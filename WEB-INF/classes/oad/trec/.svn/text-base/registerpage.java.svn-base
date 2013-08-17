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

public class registerpage extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
  writer.write("<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\"\n");
writer.write("\"http://www.w3.org/TR/RBC-html40/loose.dtd\">\n");

writer.write("<html>\n");
writer.write("<head>\n");
writer.write("<title>Registerpage</title>\n");
writer.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"main.css\" />\n");
writer.write("</head>\n");
writer.write("<body>\n");
writer.write("<div id=\"header\">\n");
writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\" />\n");
writer.write("</div>\n");
writer.write("<div id=\"socialNetworkBox\">\n");
writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>\n");
writer.write("</div>\n");
    writer.write("<div id=\"register\">\n");
        writer.write("<fieldset>\n");
        writer.write("<legend>Register</legend>\n");
        writer.write("<form action=\"logout\" method=\"GET\" style=\"float: left;\">\n");
        writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Cancel\"/>\n");
        writer.write("</form>\n");
        writer.write("<form action=\"register\" method=\"GET\" style=\"clear: left; float: left;\">\n");
        writer.write("<table><td>\n");
        writer.write("<p>First Name</p>\n");
        writer.write("<p>Last Name</p>\n");
        writer.write("<p>Username</p>\n");
        writer.write("<p>Password</p>\n");
        writer.write("<p>Confim Password &nbsp; &nbsp;</p>\n");
        writer.write("<p>email</p>\n");
        writer.write("<p><input type =\"submit\" value =\"Register\"/></p>\n");
            writer.write("</td>\n");
        writer.write("<td>\n");
            writer.write("<p><input type =\"text\" name =\"firstname\" size=\"20\" maxlength=\"50\"/><p>\n");
            writer.write("<p><input type =\"text\" name =\"lastname\" size=\"20\" maxlength=\"50\"/></p>\n");
            writer.write("<p><input type =\"text\" name =\"username\" size=\"20\" maxlength=\"50\"/></p>\n");
            writer.write("<p><input type =\"password\" name =\"password\" size=\"20\" maxlength=\"50\"/></p>\n");
            writer.write("<p><input type =\"password\" name =\"confirmpassword\" size=\"20\" maxlength=\"50\"/></p>\n");
            writer.write("<p><input type =\"text\" name =\"email\" size=\"20\" maxlength=\"50\"/></p>\n");
            writer.write("<p>&nbsp;</p>\n");
        writer.write("</td>\n");
        writer.write("</table>\n");
        writer.write("</form>\n");
        writer.write("</fieldset>\n");
        writer.write("</div>\n");
    printMsg("", writer, request);
  }

  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h1>" + msg + "</h1>\n");
    writer.write("<hr/>");
    writer.write("<div id=\"footer\">");
    writer.write("<p> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | ");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>");
    writer.write("</p>");
    writer.write("</div>");
    writer.write("</body>");
    writer.write("</html>");
  }
}
