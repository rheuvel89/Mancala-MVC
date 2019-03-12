package nl.sogyo.mancala;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        LocalDateTime dateTime = LocalDateTime.now();
        request.setAttribute("sessionId", new Data(session.getId(), null));
        session.setAttribute("sessionData", new Data("Session is set", dateTime.toString()));
        RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/hello.jsp");
        rd.forward(request, response);
    }

}