import java.io.*;

public class TestVect2 {

  public static void main(String args[]) {
    try {
      Vect vect = new Vect();
      vect.add(new Puce5("pupuce", 6));
      vect.add(new Puce1("zezette", 5));
      ObjectOutputStream flotEcriture = new ObjectOutputStream(
        new FileOutputStream("Vect_Puce1et5")
      );
      flotEcriture.writeObject(vect);
      flotEcriture.close();
      ObjectInputStream flotLecture = new ObjectInputStream(
        new FileInputStream("Vect_Puce1et5")
      );
      Vect vect2 = (Vect) flotLecture.readObject();
      flotLecture.close();
      System.out.println("vect2 : " + vect2.toString());
    } catch (IOException ioe) {
      System.out.println(" erreur :" + ioe.toString());
    } catch (ClassNotFoundException cnfe) {
      System.out.println(" erreur :" + cnfe.toString());
    }
  }
}
