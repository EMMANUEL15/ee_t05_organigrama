package Arbol;
public class Nodo<T> {  
    private NodoBinario2<T> Dat;
    //private int Fre;
    private Nodo<T> siguiente;
    //NodoBinario2 R=new NodoBinario2();
   //R.NodoBinarioc("RAIZ",suma,n2,n1);   
private Nodo(){//contructor
Dat=null;
siguiente=null;
}
public Nodo(T dato, int f){//inicializacion
NodoBinario2 R=new NodoBinario2();
R.NodoBinarioc(dato,f,null,null);   
//this.Fre=f;
siguiente=null;
}
public Nodo(NodoBinario2<T> dato,int f){ //NODO BINARIO
this.Dat=dato;
}
public Nodo(NodoBinario2<T> dato){ //NODO BINARIO
this.Dat=dato;
}
public NodoBinario2<T> getDat(){ 
return Dat;
}
public void setDato(NodoBinario2<T> dato){
this.Dat=dato;
}
public Nodo<T> getSiguiente(){
return siguiente;
}
public void setSiguiente(Nodo<T> siguiente){
this.siguiente=siguiente;
}
public String ToString(){///To String
return ""+Dat.getDato()+"  "+Dat.getP();
}
public String toString(){///To String
return ""+Dat.toString();
}
public int getFre(){ return Dat.getP() ;} 
public String getdato(){ return ""+Dat.getDato();}

}