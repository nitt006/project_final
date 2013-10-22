import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

 public class Registration extends HttpServlet
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
           ps=con.prepareStatement("insert into registration1 values(?,?,?,?,?,?)");
          }
         catch(Exception e)
         {
           e.printStackTrace();
         }
      }

      public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
         {
            PrintWriter writer=response.getWriter();

            String username=request.getParameter("name");
            String password=request.getParameter("password");
            String confirmpassword=request.getParameter("confirmpassword");
            String address=request.getParameter("address");
            int mobilenumber=Integer.parseInt(request.getParameter("mobilenumber"));
            String email=request.getParameter("email");
            String type=request.getParameter("type");

 try
  {
      writer.println("<html>");
      writer.println("<body bgcolor=green>");
      writer.println("<center>");
              if(password.equals(confirmpassword))
              {
                ps.setString(1,username);
                ps.setString(2,password);
                ps.setString(3,type);
                ps.setString(4,address);
                ps.setInt(5,mobilenumber);
                ps.setString(6,email);
                ps.executeUpdate();
              }
              else
               {
                 writer.println("<h3>PASSWORDS DONOT MATCH</h3><br><br>");
                 writer.println("<a href=registration.html>click here to register again</a>");
               }
      writer.println("<h1>YOUR ACCOUNT CREATED.</h1><br><br>");
      writer.println("<a href=login.html>click here to login to your account</a>");
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
