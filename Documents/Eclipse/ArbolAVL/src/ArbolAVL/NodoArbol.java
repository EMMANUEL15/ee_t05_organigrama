package ArbolAVL;
/**
* @author EMMANUEL
*/
public class NodoArbol<T> 
{
    private T Dato;
    private int Eq; 
    private NodoArbol<T> Izquierda;
    private NodoArbol<T> Derecha;
 public NodoArbol(T dato){
    this.Dato=dato;
    this.Izquierda=null;
    this.Derecha=null;
    this.Eq=0;
 }
 public T getDato() {
    return Dato;
 }
 public void setDato(T dato) {
    Dato = dato;
 }
 public NodoArbol<T> getIzquierda() {
    return Izquierda;
 }
 public void setIzquierda(NodoArbol<T> izquierda) {
    this.Izquierda = izquierda;
 }
 public NodoArbol<T> getDerecha() {
    return Derecha;
 }
 public void setDerecha(NodoArbol<T> derecha) {
    this.Derecha = derecha;
 }
 public int getEq(){
    
    return Eq;
    }
 public void setEq(int eq){
    this.Eq=eq;
    }
 public String ToString(){
    String s="Dato="+Dato+"   Equilibio="+Eq;
    return s;
  }
}