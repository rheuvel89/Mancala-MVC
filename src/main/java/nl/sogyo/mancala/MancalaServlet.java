package nl.sogyo.mancala;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class MancalaServlet extends HttpServlet {

    Mancala mancala = new Mancala();
    Player player1 = mancala.getActivePlayer();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { //TODO: fix winner and draw
        if (mancala.gameOver()) {
            String message = getWinnerMessage();
            request.setAttribute("mancala", new MancalaData(mancala, message));
            RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/endgame.jsp");
            rd.forward(request, response);
        } else {
            String message = getPlayerTurnMessage();
            request.setAttribute("mancala", new MancalaData(mancala, message));
            RequestDispatcher rd = request.getRequestDispatcher("../WEB-INF/jsp/mancala.jsp");
            rd.forward(request, response);
        }
    }

    private String getWinnerMessage() {
        Optional<Player> winner = mancala.getWinner();
        if (!winner.isPresent()) {
            return  "It is a draw!";
        } else {
            return "You have won player " + (winner.get() == player1 ? "1" : "2") + "!!!";
        }
    }

    private String getPlayerTurnMessage() {
        return "Your turn Player " + (mancala.getActivePlayer() == player1 ? "1" : "2") + "!";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!mancala.gameOver() && request.getPathInfo().matches("/([1-9]|1[0-2])")) {
            int position = Integer.parseInt(request.getPathInfo().substring(1));
            position = position < 7 ? position - 1 : position;
            mancala.doTurn(position);
        } else if (request.getPathInfo().matches("/restart")) {
            mancala = new Mancala();
            player1 = mancala.getActivePlayer();
        }
        doGet(request, response);
    }

}
