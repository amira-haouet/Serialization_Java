import java.io.*;
import java.util.*;

public class UsePile3 {
  public static void main(String args[]) {
      Collection<String> collection = Arrays.asList("ceci", "est", "une", "pile", "de", "mots");
      Pile3<String> pile = new Pile3<String>(collection);
      Pile3<String> pile2 = null;
      System.out.println("q(uitter), a(fficher), s(ommet), e(mpiler) mot, d(epiler), v(ide)");
      Scanner sc = new Scanner(System.in);
      String rep;       
      do {
      	rep = sc.next().trim();
      	try{
					if (rep.equals("a")) {       
						System.out.println(pile.toString());
					} else if (rep.equals("s")) {
						String mot = pile.sommet();
						System.out.println(mot);
					} else if (rep.equals("v"))          
						System.out.println(pile.estVide()?"vide":"non vide");
					else if (rep.equals("d"))      
						pile.depiler();
					else if (rep.equals("e")) {
						rep = sc.next().trim();   
						pile.empiler(rep);
						rep = "";
					}
					// Sauver les valeurs de la pile sur un fichier qui s'appelle sauvePile3
					FileOutputStream fos = new FileOutputStream("sauvePile3");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(pile);
					oos.close();
					// Lit les valeurs de l'objet pile qu'on a stocke sur le fichier
					FileInputStream fis = new FileInputStream("sauvePile3");
					ObjectInputStream ois = new ObjectInputStream(fis);
					pile2 = (Pile3) ois.readObject();
					ois.close();
					System.out.println("Pile Stockee :"+pile2.toString());
				}catch(EmptyStackException e){
					 System.out.println("Liste Vide");
					 return;
				} catch (Exception e) { }
      } while (! rep.equals("q")) ;
  }
}
