import java.io.*;

public class Puce5 implements Serializable {

  String nom = null;
  int nombrePattes = -1;

  public Puce5(String n, int nb) {
    nom = n;
    nombrePattes = nb;
  }

  public String toString() {
    return "Puce nom : " + nom + ", nombre de pattes = " + nombrePattes;
  }
}
