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

public class adminevaluationresult extends HttpServlet{

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
    writer.write("<form action=\"logout\" method=\"GET\">\n");
    writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>\n");
    writer.write("</form>\n");
    
    
    
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
            int a = 0;
            int hotel_id = Integer.parseInt(request.getParameter("evaluate_hotel_id"));
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
            Statement statement = connection.createStatement();
            ResultSet query_result = statement.executeQuery("SELECT evaluations.user_id, evaluations.id, evaluations.comment, evaluations.generell, evaluations.room, evaluations.service, evaluations.location, evaluations.gastronomy, evaluations.sports, hotel.name FROM evaluations, hotel WHERE evaluations.hotel_id = " + hotel_id + " AND hotel.id = evaluations.hotel_id");

            if(!query_result.next())
            {
            writer.write("<h2>There are no Evaluations for the Hotel you choose</h2>\n");
            writer.write("<form action=\"adminevaluationpage\" method=\"GET\">\n");
            writer.write("<input type =\"submit\" value =\"Cancel\"/>\n");
            writer.write("</form></td>\n");
            printMsg("", writer, request);
            return;
            }
            if(query_result.previous())
                a = a;
            while(query_result.next())
            {
                String evaluation_comment = query_result.getString("evaluations.comment");
                /*int evaluation_generell = Integer.parseInt(query_result.getString("evaluations.generell"));
                int evaluation_room = Integer.parseInt(query_result.getString("evaluations.room"));
                int evaluation_service = Integer.parseInt(query_result.getString("evaluations.service"));
                int evaluation_location = Integer.parseInt(query_result.getString("evaluations.location"));
                int evaluation_gastronomy = Integer.parseInt(query_result.getString("evaluations.gastronomy"));
                int evaluation_sports = Integer.parseInt(query_result.getString("evaluations.sports"));
                int evaluate_id = Integer.parseInt(query_result.getString("evaluations.id"));
                */
                String evaluation_generell = query_result.getString("evaluations.generell");
                String evaluation_room = query_result.getString("evaluations.room");
                String evaluation_service = query_result.getString("evaluations.service");
                String evaluation_location = query_result.getString("evaluations.location");
                String evaluation_gastronomy = query_result.getString("evaluations.gastronomy");
                String evaluation_sports = query_result.getString("evaluations.sports");
                String evaluate_id = query_result.getString("evaluations.id");
                int user_id = Integer.parseInt(query_result.getString("evaluations.user_id"));

                writer.write("<fieldset style=\"width:700px; height:200px; margin-left: 50px; background-image:url(output_spec.png);\">");
                writer.write("<table>\n");
                writer.write("<tr>\n");
                writer.write("<td>Generell:<td><i style=\"margin-left: 10px\">"+ evaluation_generell +"</i></td></td>\n");
                writer.write("<td>&nbsp;&nbsp;Room: <td><i style=\"margin-left: 10px\">"+ evaluation_room +"</i></td></td>\n");
                writer.write("<td>&nbsp;&nbsp;Service: <td><i style=\"margin-left: 10px\">"+ evaluation_service +"</i></td></td>\n");
                writer.write("<td>&nbsp;&nbsp;Location: <td><i style=\"margin-left: 10px\">"+ evaluation_location +"</i></td></td>\n");
                writer.write("</tr><tr><td>Gastronomy:<td ><i style=\"margin-left: 10px\">"+ evaluation_gastronomy +"</i></td></td>\n");
                writer.write("<td>&nbsp;&nbsp;Sports:<td ><i style=\"margin-left: 10px\">"+ evaluation_sports +"</i></td></td>\n");
                writer.write("<td>&nbsp;&nbsp;Comments:<td><i>"+ evaluation_comment +"</i></td></td></p>");
                writer.write("<td></td><td><form action=\"admineditevaluationresult\" method=\"GET\">\n");
                writer.write("<input type =\"hidden\" name =\"evaluation_comment\" value =\""+evaluation_comment+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"evaluation_generell\" value =\""+evaluation_generell+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"evaluation_room\" value =\""+evaluation_room+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"evaluation_service\" value =\""+evaluation_service+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"evaluation_location\" value =\""+evaluation_location+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"evaluation_gastronomy\" value =\""+evaluation_gastronomy+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"evaluation_sports\" value =\""+evaluation_sports+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"hotel_id\" value =\""+hotel_id+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"evaluate_id\" value =\""+evaluate_id+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"user_id\" value =\""+user_id+"\"/>\n");
                writer.write("<input style=\"margin-left: 100px;\" type =\"submit\" value =\"Edit\"/>\n");
                writer.write("</form>\n");
                writer.write("<form action=\"admindeleteevaluationresult\" method=\"GET\">\n");
                writer.write("<input type =\"hidden\" name =\"hotel_id\" value =\""+hotel_id+"\"/>\n");
                writer.write("<input type =\"hidden\" name =\"evaluate_id\" value =\""+evaluate_id+"\"/>\n");
                writer.write("<input style=\"margin-left: 100px;\" type =\"submit\" value =\"Delete\"/>\n");
                writer.write("</form>\n");
                writer.write("<form action=\"adminevaluationpage\" method=\"GET\">\n");
                writer.write("<input style=\"margin-left: 100px;\" type =\"submit\" value =\"Cancel\"/>\n");
                writer.write("</form></td>\n");
                writer.write("</tr>\n");
                writer.write("</table>\n");
                writer.write("</fieldset>");
            }

            writer.write("</div>\n");

            printMsg("",writer, request);
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
