
package app.simple;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SimpleServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest request,HttpServletResponse response)
  {
    try
    {
      response.setContentType("text/html");
      PrintWriter printWriter = response.getWriter();
      printWriter.println("<h2>");
      printWriter.println("This is my test file..!!!");
      String str="/ServletSimpleApp/static.jsp";
      printWriter.println("<br><a href="+str+">Test site<a/>");
      printWriter.println("</h2>");
    }
    catch (IOException ioException)
    {
      System.out.println(ioException.getMessage());
    }
  }
}
