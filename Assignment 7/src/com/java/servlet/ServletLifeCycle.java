package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/SLC")
public class ServletLifeCycle extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("ServletLifeCycle Servlet Initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service Method Called");
        System.out.println("Do GET Called");
    }

    @Override
    public void destroy() {
        System.out.println("ServletLifeCycle Servlet Destroyed");
    }
}
