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

public class adminevaluationpage extends HttpServlet{

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
    writer.write("<div id=\"search\">\n");
    writer.write("<fieldset>\n");
    writer.write("<legend style=\"color: black\">Admin Evaluate</legend>\n");
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");
    writer.write("<table><tr><td>\n");
    writer.write("<form action=\"adminevaluationresult\" method=\"GET\">\n");
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
    writer.write("<select name=\"evaluate_hotel_id\" size=\"5\">\n");
    try
    {
        HttpSession sess = request.getSession(true);
        if(sess.getValue("user") != null)
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
            Statement statement = connection.createStatement();
            ResultSet query_result = statement.executeQuery("SELECT id, name FROM hotel");
            while(query_result.next())
            {
                String hotel_name = query_result.getString("name");
                int hotel_id = Integer.parseInt(query_result.getString("id"));
                writer.write("<option value = \""+ hotel_id +"\">"+ hotel_name +"</option>\n");
            }
            writer.write("</select>\n");
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

     writer.write("</td>\n");
     writer.write("<tr>\n");
     writer.write("<td>\n");
     writer.write("<input type =\"submit\" value =\"Show Evaluations\"/>\n");
     writer.write("</form>\n");
     writer.write("<form action=\"mainpage\" method=\"GET\">\n");
     writer.write("<input type =\"submit\" value =\"Cancel\"/>\n");
     writer.write("</form>\n");
     writer.write("</td>\n");
     writer.write("</tr>\n");
     writer.write("</table>\n");
     writer.write("</fieldset>\n");
     writer.write("</div>\n");

     printMsg("",writer, request);
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
