import java.io.*;

public class Vect implements Serializable {

  private Object[] tabElement = new Object[10];
  private transient int taille = 0;

  public Object elementAt(int index) throws ArrayIndexOutOfBoundsException {
    if (index >= taille) throw new ArrayIndexOutOfBoundsException(
      index
    ); else return tabElement[index];
  }

  public void add(Object element) {
    if (tabElement.length == taille) resize(tabElement.length * 2);
    tabElement[taille++] = element;
  }

  public String toString() {
    StringBuffer res = new StringBuffer("[ ");
    for (int i = 0; i < taille - 1; ++i) res.append(tabElement[i] + ", ");
    if (taille > 0) res.append(tabElement[taille - 1] + " ");
    res.append("]");
    return res.toString();
  }

  private void resize(int nouvelleTaille) {
    Object[] newTabElement = new Object[nouvelleTaille];
    System.arraycopy(tabElement, 0, newTabElement, 0, nouvelleTaille);
    tabElement = newTabElement;
    taille = nouvelleTaille;
  }

  private void writeObject(ObjectOutputStream flotOut) throws IOException {
    if (tabElement.length > taille) resize(taille);
    flotOut.defaultWriteObject();
  }

  private void readObject(ObjectInputStream flotIn)
    throws IOException, ClassNotFoundException {
    flotIn.defaultReadObject();
    taille = tabElement.length;
  }
}
