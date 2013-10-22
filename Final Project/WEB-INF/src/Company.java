
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

 public class Company extends HttpServlet
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
           ps=con.prepareStatement("select * from company where name=?");
          }
         catch(Exception e)
         {

           e.printStackTrace();
         }
      }

      public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
         {
            PrintWriter writer=response.getWriter();

           String nam=request.getParameter("company");
  System.out.println(nam);

    try
  {
      writer.println("<html>");
      writer.println("<body bgcolor=wheat>");



      ps.setString(1,nam);
                  ResultSet rs=ps.executeQuery();
                  int k=1;

  while(rs.next())
  {System.out.println("true");
   String username=rs.getString(1);
   String password=rs.getString(2);
   String usertype=rs.getString(3);

     writer.println("<h3>NO."+k+"</h3><br>");
     writer.println("<h5>NAME : "+username+"</h5><br>");
     writer.println("<h5>SECTOR : "+password+"</h5><br>");
     writer.println("<h5>DETAILS : "+usertype+"</h5><br>");
 k++;

  }System.out.println("$true");
      writer.println("<h1>$ THESE ARE THE DETAILS OF THE SEARCH.</h1><br><br>");
      writer.println("<a href=homepage.html>click here to go to homepage</a>");

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


