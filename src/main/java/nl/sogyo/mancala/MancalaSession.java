package nl.sogyo.mancala;

public class MancalaSession {

    private Mancala mancala;
    private Player player1;
    private String message;
    private int[] bowls = new int[14];


    public MancalaSession() {
        mancala = new Mancala();
        player1 = mancala.getActivePlayer();
        for (int i = 0 ; i < bowls.length ; i++) {
            bowls[i] = mancala.getCountOf(i);
        }
    }

    public Mancala getMancala() {
        return mancala;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getBowl1Count() {
        return bowls[0];
    }

    public int getBowl2Count() {
        return bowls[1];
    }

    public int getBowl3Count() {
        return bowls[2];
    }

    public int getBowl4Count() {
        return bowls[3];
    }

    public int getBowl5Count() {
        return bowls[4];
    }

    public int getBowl6Count() {
        return bowls[5];
    }

    public int getKalaha1Count() {
        return bowls[6];
    }

    public int getBowl7Count() {
        return bowls[7];
    }

    public int getBowl8Count() {
        return bowls[8];
    }

    public int getBowl9Count() {
        return bowls[9];
    }

    public int getBowl10Count() {
        return bowls[10];
    }

    public int getBowl11Count() {
        return bowls[11];
    }

    public int getBowl12Count() {
        return bowls[12];
    }

    public int getKalaha2Count() {
        return bowls[13];
    }

    public int[] getBowlCount() {
        return bowls;
    }

}
