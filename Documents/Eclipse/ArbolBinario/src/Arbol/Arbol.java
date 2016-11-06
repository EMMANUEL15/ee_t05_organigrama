package Arbol;

public class Arbol<T> {
	public NodoBinario<T>raiz;
	NodoBinario R=new NodoBinario(null);
	
private Arbol(){
		raiz=null;
}
public void Arbol(T dato){
	this.raiz=new NodoBinario<T>(dato);
}
public void Arbol(NodoBinario<T> raiz){
	this.raiz=raiz;
}
public NodoBinario<T> getRaiz() {
	return raiz;
}
public void setRaiz(NodoBinario<T> raiz) {
	this.raiz = raiz;
}
public void preOrden(NodoBinario<T> raiz){
		if(raiz!=null){
			System.out.println(raiz.getDato());
		preOrden(raiz.getIzquierda());
		preOrden(raiz.getDerecha());
		
		}
		
}
public void leer(String cadena){
	try{
	Arbol a=new Arbol(); 
	String dato=null;
	System.out.println(cadena);
	String[] x=cadena.split("");
	System.out.println(" la cadena mide  "+cadena.length());
	//NodoBinario R=new NodoBinario("¿?");
	for(int i=0;i<cadena.length();i++){
		
		if(x[i+1].equals("-")){//System.out.println("----->"+x[i+2]);
		dato=x[i+2];
		  a.crear(R,x[i-1],dato);
		}else{
			a.crear(R,x[i],null);
		}
	}
	
}catch(Exception e){
	Arbol a=new Arbol(); 
	a.preOrden(R);}
}
public void crear(NodoBinario<T> raiz,String c,String dato){
	//System.out.println("raiz = "+R.getDato());
NodoBinario N0=new NodoBinario(dato);
	if(c.equals("0")){
		if(raiz.getIzquierda()!=null){
			System.out.println("AVANZAR IZQ "+raiz.getDato());
			crear(raiz.getIzquierda(),c,dato);
		}else{
			if(raiz.getDato()==null){System.out.println("si");
			System.out.println("CREAR IZQ "+dato);
			raiz.setIzquierda(N0);
			
			}else{System.out.println("No");}
			
		}
	}else if(c.equals("1")){
		if(raiz.getDerecha()!=null){
			System.out.println("AVANZAR DERE "+raiz.getDato());
			crear(raiz.getDerecha(),c,dato);
		}else{
			System.out.println("CREAR DERE "+dato);
			raiz.setDerecha(N0);
		}
	
	if(c.equals("-")||c.equals("|")||c.equals("0")||c.equals("1")){}else{
		System.out.println("\t--->"+c);
	}
	}
}

/**
 * iif(raiz.getIzquierda()!=null||raiz.getDerecha()!=null){
		//System.out.println("=="+raiz.getDato());
		crear(raiz.getIzquierda(),c);
		crear(raiz.getDerecha(),c);
		}

	
	if(c.equals("0")){System.out.println("I");
		raiz.setIzquierda(N0);
		//crear(raiz.getIzquierda(),c);
	}else if(c.equals("1")){System.out.println("D");
		raiz.setDerecha(N0);
		//crear(raiz.getDerecha(),c);
	}else if(c.equals("||")){
		System.out.println("El arbol se ha creado exitosamnte!");
	}else {
		System.out.println("en caracter "+c+" no pertenece aqui");
	}
	}catch(Exception e){}
	
	********
	*if(dato!=null){
	if(c.equals("0")){
		if(raiz.getIzquierda()!=null){
			System.out.println("AVANZAR IZQ");
			crear(raiz.getIzquierda(),c,dato);
		}else if(raiz.getDato()==null){
			System.out.println("CREAR IZQ");
			System.out.println("cambiar "+raiz.getDato());
			raiz.setIzquierda(N0);
		}
	}else if(c.equals("1")){
		if(raiz.getDerecha()!=null){
			System.out.println("AVANZAR DERE");
			crear(raiz.getDerecha(),c,dato);
		}else{
			System.out.println("CREAR DERE "+dato);
			raiz.setDerecha(N0);
		}
}
else{
 */
	


public void Creado(){
	Arbol a=new Arbol();
	Integer num=(int)(Math.random()*2);
	NodoBinario N1=new NodoBinario(num);
	num=(int)(Math.random()*2);
	NodoBinario N2=new NodoBinario(num);
	NodoBinario N3=new NodoBinario("3");
	NodoBinario N4=new NodoBinario("4");
	NodoBinario N5=new NodoBinario("5");
	NodoBinario N6=new NodoBinario("6");
	NodoBinario N7=new NodoBinario("7");
	
	
	N1.setIzquierda(N2);
	N1.setDerecha(N3);
	
	N2.setIzquierda(N4);
	N2.setDerecha(N5);
	
	N3.setIzquierda(N6);
	N3.setDerecha(N7);
	
	a.preOrden(N1);
}
public static void main(String []args){
	Arbol a=new Arbol();
	//a.Creado();
	
	//NodoBinario R=new NodoBinario("!!");
	//a.crear(R);
	//a.crear(R);
	//System.out.println("Arbol Completo");
	//a.preOrden(R);
	a.leer("000-L001-O01-A100-H101-.111-*||");
	
	
}
}
