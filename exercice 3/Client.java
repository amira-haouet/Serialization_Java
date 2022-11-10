import java.io.*;
import java.net.Socket;
import java.util.*;

public class Client {

  //Lorsqu'on lance les deux programmes, le serveur envoie 10 lignes sur le socket et il est lu dans le client et affiché sur le terminal.

  public static void main(String[] args) {
    Socket soc = null;
    Puce5 puce = null;
    try {
      soc = new Socket("localhost", 7770);
      ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());

      while (true) {
        puce = (Puce5) ois.readObject();
        if (puce == null) break;
        System.out.println("puce : " + puce.toString());
      }
    } catch (Exception e) {}
    //catch (IOException e) {}
    //catch (ClassNotFoundException e){}
  }
}
