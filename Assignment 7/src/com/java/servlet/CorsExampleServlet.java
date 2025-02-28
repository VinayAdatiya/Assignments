package servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/data")
public class CorsExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setAttribute("title","Hello World");
        String origin = req.getHeader("Origin"); // Get the origin from the request
        System.out.println("getParameterMap :- "+req.getParameterMap().values());
        System.out.println("getParameterNames :- "+req.getParameterNames().toString());
        System.out.println("Context Path :- "+req.getContextPath());
        System.out.println("Servlet Path :- "+req.getContextPath());
        System.out.println("Request URI :- "+req.getRequestURI());
        System.out.println("Request URL :- "+req.getRequestURL());
        System.out.println("Header Names :- "+req.getHeaderNames());
        System.out.println("Method Name :- "+req.getMethod());
        System.out.println("Remote User :- "+req.getRemoteUser());



        // Check the origin and set CORS headers accordingly
        if ("http://localhost:8081".equals(origin) || "*".equals(origin)) {
            resp.setHeader("Access-Control-Allow-Origin", origin);
            resp.setHeader("Access-Control-Allow-Methods", "GET");
            resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
            resp.setHeader("Access-Control-Allow-Credentials", "true");
        }

        resp.setContentType("application/json"); // Set the content type
        resp.getWriter().write("{\"message\": \"Data from the API\"}"); // Send some data
    }
}

