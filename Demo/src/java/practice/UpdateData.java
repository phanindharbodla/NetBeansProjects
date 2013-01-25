package practice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UpdateData() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ConnectionObject.preProcess("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/phanindhar", "root", "root");
            int temp = Integer.parseInt(request.getParameter("Id"));
            if (ConnectionObject.IsThere(temp)) {
                ConnectionObject.update(Integer.parseInt(request.getParameter("Id")), request.getParameter("Name"), request.getParameter("Email"));
                response.sendRedirect("notify1.html");
            } else {
                response.sendRedirect("notifyundel.html");
            }
            ConnectionObject.endProcess();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
