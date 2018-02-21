package connexionBDD;

import bean.Match;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mesParis extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";
    private static final String passwordDBB = "root";

    public List<Match> getListeMatch() {
        return listeMatch;
    }

    public void setListeMatch(List<Match> listeMatch) {
        this.listeMatch = listeMatch;
    }

    private List<Match> listeMatch;

    public void lesParis() {
        listeMatch = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, passwordDBB);
            Statement statement = con.createStatement();


        int idcompte = (Integer) getVariablesSession().get("idUser");
        ResultSet resultat = statement.executeQuery( "SELECT EQUIPE_DOM, EQUIPE_EXT, SCORE_DOM, SCORE_EXT FROM pari INNER JOIN infomatch ON pari.ID_COMPTE_PARI = " + idcompte + " AND pari.ID_MATCH_PARI = infomatch.ID_MATCH;");
        int idMatch = 0;
        while (resultat.next()){
            String equipeDOM = resultat.getString("EQUIPE_DOM");
            String equipeEXT = resultat.getString("EQUIPE_EXT");
            int resultatDOM = resultat.getInt("SCORE_DOM");
            int resultatEXT = resultat.getInt("SCORE_EXT");
            int equipeGagnante = -2;
            Match m = new Match(idMatch, equipeDOM, equipeEXT, resultatDOM, resultatEXT, equipeGagnante);
            listeMatch.add(m);
            idMatch++;
        }
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
        lesParis();
        return SUCCESS;
    }


  }
