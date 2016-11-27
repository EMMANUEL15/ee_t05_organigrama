package ee_t05_organigrama;
public class Informacion<T>{
	 private T Dato;
	 private Lista<Informacion<T>> Hijos;
	 private Informacion<T> siguiente;
private Informacion()
{//contructor
Dato=null;
Hijos=new Lista<Informacion<T>>();
siguiente=null;
}
public Informacion(T dato){//inicializacion
this.Dato=dato;
Hijos=new Lista<Informacion<T>>();
siguiente=null;
}

public T getDato(){
	
	return Dato;
}
public void setDato(T dato){
	this.Dato=dato;
	}
public Informacion<T> getSiguiente(){
	return siguiente;
	}
public void setSiguiente(Informacion<T> N){
	this.siguiente=N;
	}
public Lista<Informacion<T>> getHijos(){
	return Hijos;
	}
public void setHijos(Lista<Informacion<T>> listal){
	Hijos=listal;
	}
public void setHijos(T dato,Lista<Informacion<T>> listal){ 
Informacion<T> hijo=new Informacion<T>(dato);
listal.Incertar(hijo);
}


public void getExtrHijo(){
}


public String ToString(){
return ""+Dato+"  "+Hijos.returnDato();
}
}