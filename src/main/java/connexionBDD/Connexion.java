package connexionBDD;

import java.sql.*;

public class Connexion extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";
    private static final String mdpBDD = "root";

    private String pseudo;
    private String password;

    public int connexion(String nom, String passwordUser) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, mdpBDD);
            int idCompte;
            int admin;
            try (Statement statement = con.createStatement()) {
                try (ResultSet resultat = statement.executeQuery("SELECT ID_COMPTE, ADMIN FROM compte WHERE NOM = '" + nom + "' AND PASSWORD='" + passwordUser + "'")) {
                    idCompte = -1;
                    admin = -1;
                    while (resultat.next()) {
                        idCompte = resultat.getInt("ID_COMPTE");
                        admin = resultat.getInt("ADMIN");
                    }
                }
            }
            getVariablesSession().put("idUser", idCompte);
            return admin;
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
        return -1;
    }



    public String execute() throws Exception {
            int id = connexion(this.pseudo, this.password);
            if(id == 0){
                return "basicUSER";
            }
            if(id == 1){
                return "admin";
            }
            addFieldError("pseudo", "IDENTIFIANTS INCORRECTS ! &");
            return ERROR;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
