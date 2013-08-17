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

public class passwordforgottenpage extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>PasswordForgottenPage</title>\n");
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"main.css\" />\n");
    writer.write("</head>\n");
    writer.write("<body>\n");
    writer.write("<div id=\"header\" align = \"center\">\n");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\" />\n");
    writer.write("</div>\n");
    writer.write("<div id=\"socialNetworkBox\">\n");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>\n");
    writer.write("</div>\n");
    writer.write("<div id =\"evaluate\">\n");
    writer.write("<fieldset style=\"width: 880px\">\n");
    writer.write("<legend>Password forgotten</legend>\n");
    writer.write("<form action=\"passwordforgotten\" method=\"GET\">\n");
    writer.write("<p>If you habe lost your password, type username and email and you become a new password on your email account!</p>\n");
    writer.write("<p>username <input type=\"text\" name=\"username\"  size=\"20\" maxlength=\"50\" /></p>\n");
    writer.write("<p>email &nbsp; &nbsp; &nbsp;&nbsp;<input type=\"text\" name=\"email\"  size=\"20\" maxlength=\"50\" /></p>\n");
    writer.write("<table><tr>\n");
    writer.write("<td><input type =\"submit\" value =\"submit\"/></td>\n");
    writer.write("</form>\n");
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<td><input style=\"margin-left:50px\" type =\"submit\" value =\"Cancel\"/></td>\n");
    writer.write("</tr></table>\n");
    writer.write("</form>\n");
    writer.write("<br><br><br>\n");
    writer.write("</fieldset>\n");
    writer.write("</div>\n");
    printMsg("", writer, request);
    }

  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h1>" + msg + "</h1>\n");
    writer.write("<hr/>\n");
    writer.write("<div id=\"footer\">\n");
    writer.write("<p align = \"center\"> <a href=\"impressum\" title=\"Impressum\">Impressum</a> | \n");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>\n");
    writer.write("</p>\n");
    writer.write("</div>\n");
    writer.write("</body>\n");
    writer.write("</html>\n");
  }
}
