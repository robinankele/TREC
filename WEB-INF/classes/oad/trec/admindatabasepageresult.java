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

public class admindatabasepageresult extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
      writer.write("<html>\n");
      writer.write("<head>\n");
      writer.write("<title>AdminDatabasePage</title>\n");
      writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
      writer.write("</head>");
      writer.write("<body>");
      writer.write("<div id=\"header\" align = \"center\">");
      writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>");
      writer.write("</div>");
      writer.write("<div id=\"socialNetworkBox\">");
      writer.write("<a class=\"fb\" href=\"http://www.facebook.com/people/Robin-Ankele/100001418077120\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>");
      writer.write("</div>\n");
      writer.write("<div id =\"evaluate\">\n");
      writer.write("<form action=\"logout\" method=\"GET\">\n");
      writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>\n");
      writer.write("</form>\n");

      String sql = request.getParameter("sql");
      if((sql == null) || (sql.length() == 0))
      {
        printMsg("Please type a Sql Query!", writer, request);
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
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
            Statement statement = connection.createStatement();
            int insert = 0;
            insert = sql.indexOf("insert");
            int select = 0;
            select = sql.indexOf("select");
            int update = 0;
            update = sql.indexOf("update");
            int delete = 0;
            delete = sql.indexOf("delete");
            int drop = 0;
            drop = sql.indexOf("drop");
            if(insert == 0 || drop == 0 || update == 0 || delete == 0)
            {
                int row = statement.executeUpdate(sql);
                printMsg("Successfully executed Command!", writer, request);
            }
            if(select != -1)
            {
                ResultSet query_result = statement.executeQuery(sql);
                writer.write("<table>\n");
                String result[] = null;
                while(query_result.next())
                {
                    for(int count = 0; count < 10; count ++)
                    {
                    result[count] = query_result.getString(1);
                    }

                  writer.write("<tr><td>"+result+"</td></tr>\n");
                }
                writer.write("</table>\n");
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
        printMsg("Database error!", writer, request);
      }
   
      writer.write("<table><tr>\n");
      writer.write("<td>\n");
      writer.write("<form action=\"admindatabasepage\" method=\"GET\">\n");
      writer.write("<td><input style=\"margin-left:0px\" type =\"submit\" value =\"Cancel\"/></td>\n");
      writer.write("</tr></table>\n");
      writer.write("</form>\n");
      writer.write("<br><br><br>\n");
      writer.write("</div>\n");
      
  }
    private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h2 style=\"clear: left;\">" + msg + "</h2>\n");
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