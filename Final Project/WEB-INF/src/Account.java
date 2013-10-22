import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

 public class Account extends HttpServlet
   {

      Connection con;
      PreparedStatement ps,ps1,ps2;



     public void init() throws ServletException
     {

       ServletContext context=getServletContext();
       String driver=context.getInitParameter("p1");
       String cs=context.getInitParameter("p2");
       String username=context.getInitParameter("p3");
       String password=context.getInitParameter("p4");

        try
          {

           Class.forName(driver);
           con=DriverManager.getConnection(cs,username,password);
           ps=con.prepareStatement("insert into profile values(?,?,?,?,?,?,?,?,?)");
           ps1=con.prepareStatement("select * from registration1 where username='?'");
          }
         catch(Exception e)
         {

           e.printStackTrace();
         }
      }

      public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
         {
            PrintWriter writer=response.getWriter();

            String username=request.getParameter("u_id");
            String highschool=request.getParameter("highschool");
            String highersecondary=request.getParameter("highersecondary");
            String ug=request.getParameter("ug");
            String pg=request.getParameter("pg");
            String aoi=request.getParameter("details");
            String submit=request.getParameter("save");
            String cn=request.getParameter("cn");
            String email=request.getParameter("em");
            String contact=request.getParameter("cont");

  if(submit.equals("SAVE"))
  {

 try
  {
      writer.println("<html>");
      writer.println("<body bgcolor=wheat>");
      writer.println("<center>");

                ps.setString(1,username);
                ps.setString(2,highschool);
                ps.setString(3,highersecondary);
                ps.setString(4,ug);
                ps.setString(5,pg);
                ps.setString(6,aoi);
                ps.setString(7,cn);
                ps.setString(8,contact);
                ps.setString(9,email);
                ps.executeUpdate();


      writer.println("<h1>CHANGES SAVED.</h1><br><br>");
      writer.println("<a href=homepage.html>click here to go to homepage</a>");
      writer.println("</center>");
      writer.println("</body>");
      writer.println("</html>");
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    }




    else if(false)
    {
    try
  {  System.out.println("right");
      writer.println("<html>");
      writer.println("<body bgcolor=wheat>");
      writer.println("<center>");

      String name=request.getParameter("user");
      ps1.setString(1,name);
                  ResultSet rs=ps1.executeQuery();


      writer.println("<h1>CHANGES SAVED1.</h1><br><br>");
      writer.println("<a href=account.html>click here to login to your account</a>");
      writer.println("</center>");
      writer.println("</body>");
      writer.println("</html>");
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    }
         }
         public void destroy()
      {
      try
      {
      ps.close();
       con.close();
       }

       catch(Exception e)
    {
      e.printStackTrace();
    }

      }

   }

