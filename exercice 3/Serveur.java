import java.io.*;
import java.net.*;

class Serveur {

  public static void main(String args[]) {
    ServerSocket server = null;
    Socket sock = null;
    PrintWriter sockOut = null;
    Puce5 puce = null;
    try {
      server = new ServerSocket(7770);
      while (true) {
        sock = server.accept();
        sockOut = new PrintWriter(sock.getOutputStream(), true);

        ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
        //create les puces
        for (int i = 0; i < 10; i++) {
          puce = new Puce5("amogus" + i, i);
          oos.writeObject(puce);
        }

        puce = null;
        oos.writeObject(puce);

        sockOut.close();
        sock.close();
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        server.close();
      } catch (IOException e2) {
        System.out.println(e2.getMessage());
      }
    }
  }
}
