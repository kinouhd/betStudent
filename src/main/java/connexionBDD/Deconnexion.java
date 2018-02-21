package connexionBDD;

import java.sql.*;

public class Deconnexion extends Environnement{
    private static final String url = "jdbc:mysql://localhost:8889/betstudent";
    private static final String user = "root";
    private static final String passwordDBB = "root";



    public String execute() throws Exception {
            getVariablesSession().remove("idUser");
            return SUCCESS;
    }


}
