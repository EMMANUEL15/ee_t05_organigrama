package detonadores;

public class NodoA<T>{
	 private T Dato;
	 private NodoA<T> siguiente;
private NodoA(){//contructor
Dato=null;
siguiente=null;
}
public NodoA(T dato){//inicializacion
this.Dato=dato;
siguiente=null;
}
public T getDato(){ 
return Dato;
}
public void setDato(T dato){
this.Dato=dato;
}
public NodoA<T> getSiguiente(){
return siguiente;
}
public void setSiguiente(NodoA<T> siguiente){
this.siguiente=siguiente;
}
public String ToString(){///To String
return ""+Dato;
}
}