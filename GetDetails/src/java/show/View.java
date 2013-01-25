/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package show;

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

/**
 *
 * @author j1013563
 */
public class View extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Contacts</title>");
            out.println("<style type=\"text/css\">");
            out.println("<!--@import url(\"css/bootstrap.min.css\");-->");
            out.println("</style>");
            out.println("</head>");
            out.println("<body align=\"center\">");
            //out.println("<h1>Contacts </h1>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phanindhar", "root", "root");
                PreparedStatement prest;
                prest = con.prepareStatement("select * from records");
                ResultSet rs = prest.executeQuery("Select * from records");
                out.println("<table align=\"center\"  width=\"50%\"><tr align=\"left\">");
                out.println("<th><h2>ID</h2></th> ");
                out.println("<th><h2>Name</h2></th>");
                out.println("<th><h2>Mobile</h2></th>");
                out.println("</tr>");
                while (rs.next() == true) {
                    out.println("<tr align=\"left\">");
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String mobile = rs.getString(3);

                    out.println("<h3><th>" + id + "</h3></td>");
                    out.println("<h3><th>" + name + "</h3></td>");
                    out.println("<h3><th>" + mobile + "</h3></td>");
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
