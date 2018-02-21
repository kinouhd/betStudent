package connexionBDD;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pari extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";

    private static final String passwordDBB = "root";

    private int idMatch;
    private String equipeDOM;
    private String equipeEXT;

    private List<Integer> score;



    public void genererMatch() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, passwordDBB);
            Statement statement = con.createStatement();
            ResultSet resultat = statement.executeQuery( "SELECT EQUIPE_DOM, EQUIPE_EXT FROM infomatch WHERE ID_MATCH = " + idMatch + ";");
            while (resultat.next()){
                this.equipeDOM = resultat.getString("EQUIPE_DOM");
                this.equipeEXT = resultat.getString("EQUIPE_EXT");
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
        score = new ArrayList<>();
        for(int i = 0; i < 16 ;i++){
            score.add(i);
        }

    }



    public String execute() throws Exception {
        genererMatch();
        return SUCCESS;
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

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }
}
