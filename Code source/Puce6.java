public class Puce6 {

  private String nom = null;
  private int nombrePattes = 0;

  public Puce6() {}

  public String getNom() {
    return nom;
  }

  public void setNom(String n) {
    this.nom = n;
  }

  public int getNombrePattes() {
    return nombrePattes;
  }

  public void setNombrePattes(int np) {
    if (np > 0) this.nombrePattes = np;
  }

  public String toString() {
    return "Puce nom : " + nom + ", nombre de pattes = " + nombrePattes;
  }
}
