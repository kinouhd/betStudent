package connexionBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Joueur;

public class goToClassement extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";
    private static final String passwordDBB = "root";

    private List<Joueur> listeJoueurs;

    public void genererClassement() {
        setListeJoueurs(new ArrayList<>());
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, passwordDBB);
            Statement statement = con.createStatement();
            ResultSet resultat = statement.executeQuery( "SELECT NOM, POINTS_CLASSEMENT, ADMIN FROM compte ORDER BY POINTS_CLASSEMENT DESC ;");
            int position = 0;
            while (resultat.next()){

                String nom = resultat.getString("NOM");
                int points = resultat.getInt("POINTS_CLASSEMENT");
                int admin = resultat.getInt("ADMIN");
                Joueur j;
                if(admin != 1){
                    position++;
                    j = new Joueur(position, nom, points, true);
                    getListeJoueurs().add(j);
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
        genererClassement();
        return SUCCESS;
    }


    public List<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(List<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }
}
