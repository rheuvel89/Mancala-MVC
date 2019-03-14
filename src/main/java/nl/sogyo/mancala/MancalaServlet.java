package nl.sogyo.mancala;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class MancalaServlet extends HttpServlet {

    Mancala mancala;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { //TODO: fix winner and draw
        HttpSession session = request.getSession();
        mancala = (Mancala)session.getAttribute("session");
        if (mancala == null) {
            mancala = new Mancala();
            session.setAttribute("session", mancala);
        }
        dispatch(request, response, session);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        mancala = (Mancala)session.getAttribute("session");
        if (mancala == null || request.getPathInfo().matches("/restart")) {
            mancala = new Mancala();
            session.setAttribute("session", mancala);
        } else if (!mancala.gameOver() && request.getPathInfo().matches("/([1-9]|1[0-2])")) {
            int position = Integer.parseInt(request.getPathInfo().substring(1));
            position = position < 7 ? position - 1 : position;
            mancala.doTurn(position);
        }
        dispatch(request, response, session);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        if (mancala.gameOver()) {
            String message = getWinnerMessage(mancala, mancala.getWinner());
            request.setAttribute("data", new MancalaData(mancala, message));
            RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/endgame.jsp");
            rd.forward(request, response);
        } else {
            String message = getPlayerTurnMessage(mancala, mancala.getPlayer1());
            request.setAttribute("data", new MancalaData(mancala, message));
            RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/mancala.jsp");
            rd.forward(request, response);
        }
    }

    private String getWinnerMessage(Mancala mancala, Optional<Player> winner) {
        if (!winner.isPresent()) {
            return  "It is a draw!";
        } else {
            return "You have won player " + (winner.get() == mancala.getPlayer1() ? "1" : "2") + "!!!";
        }
    }

    private String getPlayerTurnMessage(Mancala mancala, Player player1) {
        return "Your turn Player " + (mancala.getActivePlayer() == player1 ? "1" : "2") + "!";
    }

}
