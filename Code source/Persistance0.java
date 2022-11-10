import java.io.*;

public class Persistance0 {

  public static void main(String[] args) {
    try {
      Puce1 puce = new Puce1("pupuce", 6);
      System.out.println("puce : " + puce.toString());
      FileOutputStream fos = new FileOutputStream("sauvePuce");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(puce);
      oos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
