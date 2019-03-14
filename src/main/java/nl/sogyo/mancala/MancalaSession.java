package nl.sogyo.mancala;

public class MancalaSession {

    private Mancala mancala;
    private Player player1;

    public MancalaSession() {
        mancala = new Mancala();
        player1 = mancala.getActivePlayer();
    }

    public Mancala getMancala() {
        return mancala;
    }

    public Player getPlayer1() {
        return player1;
    }

}
