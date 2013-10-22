import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

 public class Login extends HttpServlet
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
           ps=con.prepareStatement("select * from registration1 where username=? and password=? and user_type=?");
          }
         catch(Exception e)
         {
           e.printStackTrace();
         }
      }




       public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
         {
            PrintWriter writer=response.getWriter();
            HttpSession session=request.getSession();

            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String type=request.getParameter("type");


            System.out.println(username+password+type);

            session.setAttribute("user",username);

 try
  {
      writer.println("<html>");
      writer.println("<body bgcolor=green>");
      writer.println("<center>");
       ps.setString(1,username);
       ps.setString(2,password);
       ps.setString(3,type);
       ResultSet rs=ps.executeQuery();

       if(rs.next())
       {
         writer.println("<h1>LOGIN SUCCESSFUL</h1><br><br>");
         writer.println("<a href=account.html>click here to see your account</a>");
       }
       else

       {
         writer.println("<h1>LOGIN FAILED</h1><br><br>");
         writer.println("<a href=login.html>click here to login again</a>");
       }
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
       // session.close();
        ps.close();
        con.close();
      }

       catch(Exception e)
    {
      e.printStackTrace();
    }

      }
  }
