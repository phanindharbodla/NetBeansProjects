package practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body align=\"center\">");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phanindhar", "root", "root");
                PreparedStatement prest;
                prest = con.prepareStatement("select * from records");
                ResultSet rs = prest.executeQuery("Select * from records");
                out.println("<table align=\"center\"  width=\"50%\"><tr align=\"left\">");
                out.println("<th><h2>ID</h2></th> ");
                out.println("<th><h2>Name</h2></th>");
                out.println("<th><h2>Email</h2></th>");
                out.println("</tr>");
                while (rs.next() == true) {
                    out.println("<tr align=\"left\">");
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String mail = rs.getString(3);

                    out.println("<h3><th>" + id + "</h3></td>");
                    out.println("<h3><th>" + name + "</h3></td>");
                    out.println("<h3><th>" + mail + "</h3></td>");
                    out.println("</tr>");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
