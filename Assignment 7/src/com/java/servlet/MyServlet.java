package servlet;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.net.URLEncoder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class MyServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String name = request.getParameter("name");
            String encodedName = URLEncoder.encode(name, "UTF-8");
            System.out.println("Encoded Name :- "+encodedName);
            String url = "NextServlet?name=" + encodedName;
            response.sendRedirect(url);
    }
}
