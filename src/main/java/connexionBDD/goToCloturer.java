package connexionBDD;

import bean.Match;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class goToCloturer extends Environnement{
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

    public void genererMatch() {
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
            ResultSet resultat = statement.executeQuery( "SELECT ID_MATCH, EQUIPE_DOM, EQUIPE_EXT, RESULTAT_DOM, RESULTAT_EXT, VICTOIRE_EQUIPE FROM infomatch;");
            while (resultat.next()){
                String equipeDOM = resultat.getString("EQUIPE_DOM");
                String equipeEXT = resultat.getString("EQUIPE_EXT");
                int resultatDOM = resultat.getInt("RESULTAT_DOM");
                int resultatEXT = resultat.getInt("RESULTAT_EXT");
                int equipeGagnante = resultat.getInt("VICTOIRE_EQUIPE");
                int idMatch = resultat.getInt("ID_MATCH");
                if(equipeGagnante == -1){
                    Match m = new Match(idMatch, equipeDOM, equipeEXT, resultatDOM, resultatEXT, equipeGagnante);
                    listeMatch.add(m);
                }
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
        genererMatch();
        return SUCCESS;
    }


  }
