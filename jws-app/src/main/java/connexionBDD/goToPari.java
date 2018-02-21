package connexionBDD;

import bean.Match;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class goToPari extends Environnement{
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
                int idMatch = resultat.getInt("ID_MATCH");
                String equipeDOM = resultat.getString("EQUIPE_DOM");
                String equipeEXT = resultat.getString("EQUIPE_EXT");
                int resultatDOM = resultat.getInt("RESULTAT_DOM");
                int resultatEXT = resultat.getInt("RESULTAT_EXT");
                int equipeGagnante = resultat.getInt("VICTOIRE_EQUIPE");
                if(equipeGagnante == -1){
                    Match m = new Match(idMatch, equipeDOM, equipeEXT, resultatDOM, resultatEXT, equipeGagnante);
                    listeMatch.add(m);
                }
            }
            int idUser = (Integer) getVariablesSession().get("idUser");
            List<bean.Pari> listePari = new ArrayList<>();
            resultat = statement.executeQuery( "SELECT ID_PARI, SCORE_DOM, SCORE_EXT, ID_MATCH_PARI, ID_COMPTE_PARI FROM pari WHERE ID_COMPTE_PARI = " + idUser + ";");
            while (resultat.next()){
                int idPari = resultat.getInt("ID_PARI");
                int scoreDom = resultat.getInt("SCORE_DOM");
                int scoreExt = resultat.getInt("SCORE_EXT");
                int idMatchPari = resultat.getInt("ID_MATCH_PARI");
                int idComptePari = resultat.getInt("ID_COMPTE_PARI");
                bean.Pari p = new bean.Pari(idPari, scoreDom, scoreExt, idMatchPari, idComptePari);
                listePari.add(p);
            }

            //ON ELIMINE LES MATCHS DEJA PARIER
            for(int i = 0; i < listePari.size(); i++){
                int idMatchDuPari = listePari.get(i).getIdMatchPari();
                for(int j = 0; j < listeMatch.size(); j++){
                    if(listeMatch.get(j).getIdMatch() == idMatchDuPari){
                        listeMatch.remove(j);
                    }
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
