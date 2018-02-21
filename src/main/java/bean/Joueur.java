package bean;

public class Joueur {
    private int position;
    private String nom;
    private int pointsClassement;
    private boolean admin;

    public Joueur(int position, String nom, int pointsClassement, boolean admin){
        this.position = position;
        this.setNom(nom);
        this.setPointsClassement(pointsClassement);
        this.setAdmin(admin);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsClassement() {
        return pointsClassement;
    }

    public void setPointsClassement(int pointsClassement) {
        this.pointsClassement = pointsClassement;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
