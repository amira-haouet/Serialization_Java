import java.io.*;

public class Persistance5 {

  public static void main(String[] args) {
    try {
      Puce5 puce = new Puce5("pupuce", 4);
      System.out.println("puce : " + puce.toString());
      FileOutputStream fos = new FileOutputStream("sauvePuce");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(puce);
      oos.close();
      puce = null;
      System.out.println("puce : " + puce);
      FileInputStream fis = new FileInputStream("sauvePuce");
      ObjectInputStream ois = new ObjectInputStream(fis);
      puce = (Puce5) ois.readObject();
      ois.close();
      System.out.println("puce : " + puce.toString());
    } catch (Exception e) {}
  }
}
