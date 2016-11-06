package ee_p02_zip;

/**
* @author EMMANUEL
*/
public class NodoBinario2<T> {
   private T Dato;
   private int P;
   private NodoBinario2<T> Izquierda;
   private NodoBinario2<T> Derecha;
public NodoBinario2(){}
public void NodoBinarioc(T dato,int f,NodoBinario2<T> D,NodoBinario2<T> I){
   this.Dato=dato;
   this.P=f; 
   this.Izquierda=I;
   this.Derecha=D;
}
public void NodoBinarioc(T dato,int f){
   this.Dato=dato;
   this.P=f;
}
public void NodoBinarioc(T dato){
   this.Dato=dato;
   this.Izquierda=null;
   this.Derecha=null;
}
public T getDato() {
   return Dato;
}
public void setDato(T dato) {
   Dato = dato;
}
public NodoBinario2<T> getIzquierda() {
   return Izquierda;
}
public void setIzquierda(NodoBinario2<T> izquierda) {
   this.Izquierda = izquierda;
}
public NodoBinario2<T> getDerecha() {
   return Derecha;
}
public void setDerecha(NodoBinario2<T> derecha) {
}
public int getP(){return P;}
public void setP(int f){this.P=f;}
public String toString(){
   String s="dato="+Dato+"  frecuencia="+P+"  Izq="+Izquierda+"   DHC="+Derecha;
   return s;
}
public String ToString(){
   String s="["+Dato+" "+P+"]";
   return s;
}
public int compareTo(NodoBinario2<T> N){
   int n=0;
   if(getP()<N.getP()){
           n=-1;
   }else if(getP()>N.getP()){
           n=1;
   }
       return n;
   }
}