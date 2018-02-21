package connexionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreationMatch extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";
    private static final String passwordDBB = "root";

    private String equipeDOM;
    private String equipeEXT;



    public void creerMatch() {
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
            statement.executeUpdate( "INSERT INTO infomatch (EQUIPE_DOM, EQUIPE_EXT, RESULTAT_DOM, RESULTAT_EXT, VICTOIRE_EQUIPE) VALUES ('"+ equipeDOM + "', '"+ equipeEXT+ "', -1, -1,-1);");
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
        creerMatch();
        return SUCCESS;
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
}
