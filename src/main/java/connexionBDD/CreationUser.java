package connexionBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreationUser extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";
    private static final String passwordDBB = "root";

    private String pseudo;
    private String pswd;



    public void creerUser() {
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
            statement.executeUpdate( "INSERT INTO compte (NOM, PASSWORD, POINTS_CLASSEMENT, ADMIN) VALUES ('"+ pseudo + "', '"+ pswd+ "', 0, 0);");
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
        creerUser();
        return SUCCESS;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
