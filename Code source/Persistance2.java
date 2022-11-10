import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Persistance2 {

  public static void main(String args[]) {
    Puce6 puce = new Puce6();
    puce.setNom("pupuce");
    puce.setNombrePattes(6);
    try {
      System.out.println("puce : " + puce.toString());
      OutputStream out = new BufferedOutputStream(
        new FileOutputStream("sauve.xml")
      );
      XMLEncoder encoder = new XMLEncoder(out);
      encoder.writeObject(puce);
      encoder.close();
      puce = null;
      System.out.println("puce null");
      InputStream in = new BufferedInputStream(
        new FileInputStream("sauve.xml")
      );
      XMLDecoder decoder = new XMLDecoder(in);
      puce = (Puce6) decoder.readObject();
      decoder.close();
      System.out.println("puce : " + puce.toString());
    } catch (IOException ioe) {
      System.out.println("erreur : " + ioe.getMessage());
    }
  }
}
