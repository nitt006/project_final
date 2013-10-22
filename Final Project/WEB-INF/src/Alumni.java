import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

 public class Alumni extends HttpServlet
   {

      Connection con;
      PreparedStatement ps;



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
           ps=con.prepareStatement("select * from profile where cn=?");
          }
         catch(Exception e)
         {

           e.printStackTrace();
         }
      }

      public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
         {
            PrintWriter writer=response.getWriter();

           String name=request.getParameter("user");


    try
  {  System.out.println("right");
      writer.println("<html>");
      writer.println("<body bgcolor=wheat>");
      writer.println("<center>");


      ps.setString(1,name);
                  ResultSet rs=ps.executeQuery();
                  int k=1;

  while(rs.next())
  {
   String username=rs.getString(1);
   String password=rs.getString(6);
   String usertype=rs.getString(7);
   String contact=rs.getString(8);
   String email=rs.getString(9);

     writer.println("<h3>NO."+k+"</h3><br>");
     writer.println("<h5>NAME : "+username+"</h5><br>");
     writer.println("<h5>AOI : "+usertype+"</h5><br>");
     writer.println("<h5>COMPANY : "+password+"</h5><br>");
     writer.println("<h5>CONTACT : "+usertype+"</h5><br>");
     writer.println("<h5>Email : "+usertype+"</h5><br>");



 k++;

  }
      writer.println("<h1>THESE ARE THE DETAILS OF THE SEARCH.</h1><br><br>");
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


