package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mode.Customer;

import java.io.IOException;
import java.util.Objects;

@WebServlet()
public class Servinho extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(Objects.equals(username, "user") && Objects.equals(password, "password")){
            resp.sendRedirect("User.html");
        }else{
            resp.sendError(69, "Invalid user");
        }

        Customer customer = new Customer(username, password);
    }
}
