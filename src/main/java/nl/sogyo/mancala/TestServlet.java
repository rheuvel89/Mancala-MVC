package nl.sogyo.mancala;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class TestServlet extends HttpServlet {

    private int getCounter = 0;

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        LocalDateTime dateTime = LocalDateTime.now();
        request.setAttribute("sessionId", new Data(session.getId(), null));
        request.setAttribute("currentData", new Data("current", dateTime.toString()));
        request.setAttribute("getCounter", new Data(String.valueOf(++getCounter), null));
        RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/test.jsp");
        rd.forward(request, response);
    }

}

