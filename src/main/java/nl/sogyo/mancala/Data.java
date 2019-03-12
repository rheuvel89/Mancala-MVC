package nl.sogyo.mancala;

public class Data {

    private String string;
    private String date;

    public Data(String string, String date) {
        this.string = string;
        this.date = date;
    }

    public String getString() {
        return string;
    }

    public String getDate() {
        return date;
    }
}
