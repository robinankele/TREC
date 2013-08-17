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

public class edit extends HttpServlet{

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
    writer.write("</div>");
    HttpSession sess = request.getSession(true);
    if(sess.getValue("user") != null)
    {
        MainData main = new MainData();
        main.setProfile(  request.getParameter("last_name"),
                          request.getParameter("first_name"),
                          request.getParameter("email"),
                          request.getParameter("new_password"),
                          request.getParameter("new_password2"),
                          request.getParameter("old_password"));


        Interests interest = new Interests();
        interest.setProfile(request.getParameter("firstint"),
                request.getParameter("secondint"),
                request.getParameter("thirdint"),
                request.getParameter("intvalueone"),
                request.getParameter("intvaluetwo"),
                request.getParameter("intvaluethree"));

        Activities activ = new Activities();
        activ.setProfile(request.getParameter(  "firstact"),
                request.getParameter("secondact"),
                request.getParameter("thirdact"),
                request.getParameter("actvalueone"),
                request.getParameter("actvaluetwo"),
                request.getParameter("actvaluethree"));


        //change main data
        String actual_password = getActualPassword(request, writer);
        if(main.oldPasswordCheck(actual_password) && main.dataChanges())
            main.changeMainData(actual_password, request, writer);

        //change interests
        interest.changeInterests(request, writer);

        //change activities
        activ.changeActivities(request, writer);

          writer.write("<div id=\"evaluationresult\">");
          writer.write("<br>");
          writer.write("<fieldset>");
          writer.write("<legend>Edit Profile</legend>");
          writer.write("<form action=\"logout\" method=\"GET\">");
          writer.write("<input style=\"margin-left: 820px\" type =\"submit\" value =\"Logout\"/>");
          writer.write("</form>");
          writer.write("<form action=\"mainpage\" method=\"GET\">");
          writer.write("<h2><i>Your data has been successfully updated!</i></h2>");
          writer.write("<h3>Thanks for updating your personal data!</h3>");
          writer.write("<br>");
          writer.write("<button type =\"submit\" value=\"back\" style=\"height: 25px; width: 50px;\">back</button>");
          writer.write("<br>");
          writer.write("<br>");
          writer.write("</form>");
          writer.write("</fieldset>");
          writer.write("</div>");
     }
    else
    {
        response.sendRedirect(""+"index.html");
    }
      printMsg("",writer,request);

  }
  
  private int checkValue(String check)
  {
    if(check.equals(""))
        return 0;
    else
      return Integer.parseInt(check);
  }

  private void printMsg(String msg, PrintWriter writer, HttpServletRequest request){
    writer.write("<h1>" + msg + "</h1>\n");
    writer.write("</form>\n");
    writer.write("<hr/>");
    writer.write("<div id=\"footer\">");
    writer.write("<p> <a href=\"impressum.html\" title=\"Impressum\">Impressum</a> | ");
    writer.write("<a href=\"index.html\" title=\"TREC\">TREC</a>");
    writer.write("</p>");
    writer.write("</div>");
    writer.write("</body>");
    writer.write("</html>");
  }

private String getActualPassword(HttpServletRequest request, PrintWriter writer)
{
    try
    {

      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "student", "student");
      HttpSession sess = request.getSession(true);
      if(sess.getValue("user") != null)
      {
          String userid = ((user)sess.getValue("user")).getAccNum();
          String result = "";
          Statement statement = connection.createStatement();
          ResultSet query_result = statement.executeQuery("SELECT password FROM user WHERE id ="+ userid);
          if(query_result.next())
          {
              result = query_result.getString("password");
          }
          return result;
       }
      return "";
    }
    catch(SQLException exc)
    {
      exc.printStackTrace();
      printMsg("database error!", writer, request);
      return "";
    }
}
}
