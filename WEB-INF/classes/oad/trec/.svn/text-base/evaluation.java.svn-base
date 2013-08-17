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

public class evaluation extends HttpServlet{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    writer.write("<html>\n");
    writer.write("<head>\n");
    writer.write("<title>EvaluationResultPage</title>\n");
    writer.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"main.css\"/>\n");
    writer.write("</head>");
    writer.write("<body>");
    writer.write("<div id=\"header\" align = \"center\">");
    writer.write("<img src=\"trec.jpg\" alt=\"logo\" width=\"900\" height=\"137\"/>");
    writer.write("</div>");
    writer.write("<div id=\"socialNetworkBox\">");
    writer.write("<a class=\"fb\" href=\"http://www.facebook.com/pages/TREC/139183509474395\" target=\"_blank\" title=\"Besuch uns auch mal bei facebook\"><span>TREC @ facebook</span></a>");
    writer.write("</div>");

    String comment = request.getParameter("user_comment");
    if((comment == null) || (comment.length() == 0))
    {
      printMsg("No Comment Typed!", writer, request);
      return;
    }
    int hotel_general = Integer.parseInt(request.getParameter("HotelAllgemein"));
    int room = Integer.parseInt(request.getParameter("Zimmer"));
    int service = Integer.parseInt(request.getParameter("Service"));
    int landscape = Integer.parseInt(request.getParameter("Lage"));
    int food = Integer.parseInt(request.getParameter("Gastronomie"));
    int activities = Integer.parseInt(request.getParameter("Sport und Unterhaltung"));

    String hotel_name = request.getParameter("Hotel");
    String username = null;
    String password = null;
    String admin = null;
    String hotel_id = null;
    String user_id = null;

    try
    {
        //get Hotel ID
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
        String sql = "SELECT id FROM hotel WHERE hotel.name ='" + hotel_name + "'";
        Statement statement = connection.createStatement();
        HttpSession sess = request.getSession(true);

        if(sess.getValue("user") == null)
        {
            response.sendRedirect(""+"index.html");
            return;
        }
        else
        {
          ResultSet qry = statement.executeQuery("SELECT id FROM activeuser WHERE username = '"+ ((user)sess.getValue("user")).getAccName() +"'");
          if(qry.next())
          {
             String id = qry.getString("id");
             statement.executeUpdate("UPDATE activeuser SET id = '"+ sess.getId() + "' WHERE username = '"+username+"'");
           }
           else
           {
             statement.executeUpdate("INSERT INTO activeuser VALUES ("+ sess.getId() + ", '"+username+"'");
           }

          statement.executeUpdate("UPDATE activeuser SET id = '"+ sess.getId() + "' WHERE username = '"+username+"'");
       }

      ResultSet query_result = statement.executeQuery(sql);
      if(query_result.next())
      {
        hotel_id = query_result.getString("id");
      }
      query_result = statement.executeQuery("SELECT id FROM user WHERE username = '"+ ((user)sess.getValue("user")).getAccName() +"'");
      if(query_result.next())
      {
          user_id = query_result.getString("id");
      }
      else
      {
          printMsg("QUERY ID FROM USER WHERE USERNAME FAILED!!", writer, request);
      }

      //add into database
      sql = "INSERT INTO evaluations (hotel_id, comment, generell, room, service, location, gastronomy, sports, user_id) VALUES ('"+hotel_id+ "', '"+comment+"', '"+hotel_general+"', '"+room+"', '"+service+"', '"+landscape+"', '"+food+"', '"+activities+"', '"+user_id+"')";
      statement.executeUpdate(sql);

      writer.write("<div id=\"evaluationresult\">");
      writer.write("<br>");
      writer.write("<fieldset>");
      writer.write("<legend>Evaluation Result</legend>");
      writer.write("<form action=\"logout\" method=\"GET\">");
      writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>");
      writer.write("</form>");
      writer.write("<form action=\"mainpage\" method=\"GET\">");
      writer.write("<h2><i>Evaluation Success!</i></h2>");
      writer.write("<h3>Thanks for evaluating this hotel!</h3>");
      writer.write("<br>");
      writer.write("<button type =\"submit\" value=\"back\" style=\"height: 25px; width: 50px;\">back</button>");
      writer.write("<br>");
      writer.write("<br>");
      writer.write("</form>");
      writer.write("</fieldset>");
      writer.write("</div>");
      printMsg("",writer,request);
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("Can not add Evaluation : database error!", writer, request);
    }
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
