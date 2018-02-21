package connexionBDD;

import bean.Match;
import bean.Pari;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ValidationMatch extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";
    private static final String passwordDBB = "root";

    private int idMatch;
    private int score1;
    private int score2;

    private List<Integer> score;



    public void validerMatch() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, passwordDBB);
            Statement statement = con.createStatement();

            statement.executeUpdate( "UPDATE infomatch SET VICTOIRE_EQUIPE = '" + getVictoire() + "', RESULTAT_DOM = '"+ score1 + "', RESULTAT_EXT = '" + score2+ "' WHERE ID_MATCH = " + idMatch + ";");

            ResultSet resultat = statement.executeQuery( "SELECT ID_PARI, SCORE_DOM, SCORE_EXT, ID_COMPTE_PARI, ID_MATCH_PARI FROM pari WHERE ID_MATCH_PARI =" + idMatch + ";");
            List<bean.Pari> listePari = new ArrayList<>();
            while (resultat.next()){
                int idPari = resultat.getInt("ID_PARI");
                int scoreDom = resultat.getInt("SCORE_DOM");
                int scoreExt = resultat.getInt("SCORE_EXT");
                int idComptePari = resultat.getInt("ID_COMPTE_PARI");
                int idMatchPari = resultat.getInt("ID_MATCH_PARI");
                bean.Pari p = new Pari(idPari, scoreDom, scoreExt, idMatchPari, idComptePari);
                listePari.add(p);
            }
            for(int i = 0; i < listePari.size(); i++){
                bean.Pari p = listePari.get(i);
                int scoreDOM = p.getScoreDOM();
                int scoreEXT = p.getScoreEXT();
                int pointsClassementActuel = 0;
                resultat = statement.executeQuery( "SELECT POINTS_CLASSEMENT FROM compte WHERE ID_COMPTE =" + p.getIdComptePari() + ";");
                while (resultat.next()){
                    int pointsClassement = resultat.getInt("POINTS_CLASSEMENT");
                    pointsClassementActuel += pointsClassement;
                }

                int nbPoints = 0;
                int indiceVictoireBDD = getVictoire();
                int indiceVictoirePari = 0;
                if(scoreDOM == score1 && scoreEXT == score2){
                    nbPoints += 3; //+3 POINTS SCORE EXACT
                }
                if(scoreDOM > scoreEXT){
                    indiceVictoirePari = 1;
                }
                if(scoreDOM < scoreEXT){
                    indiceVictoirePari = 2;
                }
                if(scoreDOM == scoreEXT){
                    indiceVictoirePari = 0;
                }
                if(indiceVictoireBDD == indiceVictoirePari){
                    nbPoints += 3; //+3 POINTS DETERMINATION VICTOIRE/DEFAITE EXACT
                }

                int pointsClassementFutur = nbPoints + pointsClassementActuel;

                //MAJ DU COMPTE DE l'utilisateur
                statement.executeUpdate( "UPDATE compte SET POINTS_CLASSEMENT = '" + pointsClassementFutur + "' WHERE ID_COMPTE = " + p.getIdComptePari() + ";");

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

    public int getVictoire(){
        if(score1 > score2 ){
            return 1;
        }
        if(score1 < score2 ){
            return 2;
        }else{
            return 0;
        }

    }



    public String execute() throws Exception {
        validerMatch();
        return SUCCESS;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
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
}
