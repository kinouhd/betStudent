package connexionBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ValiderPari extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";
    private static final String passwordDBB = "root";

    private int idMatch;
    private int score1;
    private int score2;

    private List<Integer> score;

    public void insererPari() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, passwordDBB);
            Statement statement = con.createStatement();
            int idJoueur = (Integer) getVariablesSession().get("idUser");
            statement.executeUpdate( "INSERT INTO pari (SCORE_DOM, SCORE_EXT, ID_MATCH_PARI, ID_COMPTE_PARI) VALUES ("+ score1 + ", "+ score2+ ", " + idMatch + ", " + idJoueur + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if ( con != null )
                try {
            /* Fermeture de la connexion */
                    con.close();
                } catch ( SQLException ignore ) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
        }

    }



    public String execute() throws Exception {
        insererPari();
        return SUCCESS;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }
}
