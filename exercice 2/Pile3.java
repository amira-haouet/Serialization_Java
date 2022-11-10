import java.io.*;
import java.util.*;

public class Pile3<T> implements Serializable {

  private ArrayList<T> liste; //pour serializer il est important d'avoir en private sur xml

  public Pile3() {
    liste = new ArrayList<T>();
  }

  /*
  On met ? parce qu'on sait pas ce qu'on aura comme type
  */
  public Pile3(Collection<? extends T> collection) {
    // suppose que collection != null)
    if (collection == null) throw new NullPointerException(
      "argument collection null"
    );
    int taille = collection.size();
    liste = new ArrayList<T>(taille);
    int i = 0;
    for (T element : collection) liste.add(i++, element);
  }

  public void empiler(T element) {
    liste.add(element);
  }

  public T sommet() {
    int taille = liste.size();
    if (taille == 0) throw new EmptyStackException(); else return liste.get(
      taille - 1
    );
  }

  public T depiler() {
    int taille = liste.size();
    if (taille == 0) throw new EmptyStackException(); else {
      T element = liste.get(taille - 1);
      liste.remove(taille - 1);
      return element;
    }
  }

  public boolean estVide() {
    return (liste.size() == 0);
  }

  public String toString() {
    StringBuffer result = new StringBuffer("[[ ");
    int max = liste.size() - 1;
    for (int i = 0; i < max; i++) result.append(liste.get(i).toString() + ",");
    if (max >= 0) result.append(liste.get(max).toString());
    return result.toString() + " <-";
  }
}
