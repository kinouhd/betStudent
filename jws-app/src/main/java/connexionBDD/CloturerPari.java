package connexionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CloturerPari extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";
    private static final String passwordDBB = "root";

    private int idMatch;


    public void cloturerPari() {
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
            statement.executeUpdate( "UPDATE infomatch SET VICTOIRE_EQUIPE = '-2' WHERE ID_MATCH = " + idMatch + ";");
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
        cloturerPari();
        return SUCCESS;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

}
