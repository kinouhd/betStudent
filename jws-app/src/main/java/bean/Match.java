package bean;

public class Match {
    private int idMatch;
    private String equipeDOM;
    private String equipeEXT;
    private int scoreDOM;
    private int scoreEXT;
    private int equipeGagnante;

    public Match(int idMatch, String equipeDOM, String equipeEXT, int scoreDOM, int scoreEXT, int equipeGagnante) {
        this.idMatch = idMatch;
        this.equipeDOM = equipeDOM;
        this.equipeEXT = equipeEXT;
        this.scoreDOM = scoreDOM;
        this.scoreEXT = scoreEXT;
        this.equipeGagnante = equipeGagnante;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public String getEquipeDOM() {
        return equipeDOM;
    }

    public void setEquipeDOM(String equipeDOM) {
        this.equipeDOM = equipeDOM;
    }

    public String getEquipeEXT() {
        return equipeEXT;
    }

    public void setEquipeEXT(String equipeEXT) {
        this.equipeEXT = equipeEXT;
    }

    public int getScoreDOM() {
        return scoreDOM;
    }

    public void setScoreDOM(int scoreDOM) {
        this.scoreDOM = scoreDOM;
    }

    public int getScoreEXT() {
        return scoreEXT;
    }

    public void setScoreEXT(int scoreEXT) {
        this.scoreEXT = scoreEXT;
    }

    public int getEquipeGagnante() {
        return equipeGagnante;
    }

    public void setEquipeGagnante(int equipeGagnante) {
        this.equipeGagnante = equipeGagnante;
    }
}
