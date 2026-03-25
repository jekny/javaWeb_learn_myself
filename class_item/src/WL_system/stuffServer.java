package WL_system;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: stuffServer
 * Description:
 *
 * @Author jekny
 * @Create 2026/3/25 19:15
 * @Version 1.0
 */
@WebServlet(value = {"/stuff/list"})
public class stuffServer extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
