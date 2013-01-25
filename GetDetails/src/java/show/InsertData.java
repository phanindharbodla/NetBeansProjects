package show;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phanindhar", "root", "root");
            String sql = "INSERT records VALUES(?,?,?)";
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, Integer.parseInt(request.getParameter("Id")));
            prest.setString(2, request.getParameter("Name"));
            prest.setString(3, (request.getParameter("Mobile")));
            prest.executeUpdate();
            prest.close();
            con.close();
            response.sendRedirect("/GetDetails/View");
        } catch (Exception e) {
            e.printStackTrace();
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
}
