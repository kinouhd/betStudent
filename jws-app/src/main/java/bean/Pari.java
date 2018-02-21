package bean;

public class Pari {

    private int idPari, scoreDOM, scoreEXT, idMatchPari, idComptePari;

    public Pari(int idPari, int scoreDOM, int scoreEXT, int idMatchPari, int idComptePari) {
        this.idPari = idPari;
        this.scoreDOM = scoreDOM;
        this.scoreEXT = scoreEXT;
        this.idMatchPari = idMatchPari;
        this.idComptePari = idComptePari;
    }

    public int getIdPari() {
        return idPari;
    }

    public void setIdPari(int idPari) {
        this.idPari = idPari;
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

    public int getIdMatchPari() {
        return idMatchPari;
    }

    public void setIdMatchPari(int idMatchPari) {
        this.idMatchPari = idMatchPari;
    }

    public int getIdComptePari() {
        return idComptePari;
    }

    public void setIdComptePari(int idComptePari) {
        this.idComptePari = idComptePari;
    }
}
