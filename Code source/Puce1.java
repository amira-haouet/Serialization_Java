public class Puce1 {
  String nom = null;
  int nombrePattes = -1;
  public Puce1(String n, int nb) {
    nom = n; nombrePattes = nb;
  }
  public String toString() {
    return "Puce nom : " + nom +", nombre de pattes = " + nombrePattes;
  }
}
