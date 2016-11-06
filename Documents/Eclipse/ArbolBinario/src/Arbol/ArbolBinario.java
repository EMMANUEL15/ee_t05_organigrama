package Arbol;

public class ArbolBinario<T> {
	public NodoBinario<T>raiz;
private ArbolBinario(){
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
public void recorrer(){
	NodoBinario<T> aux=raiz;
	while(aux!=null){
		System.out.println("es ="+aux.getDato());
		aux=aux.getIzquierda();
	}
}
public void preOrden(NodoBinario<T> raiz){
		if(raiz!=null){
		System.out.println(raiz.getDato());
		preOrden(raiz.getIzquierda());
		preOrden(raiz.getDerecha());
		}
}
public void inOrden(NodoBinario<T>raiz){
		if(raiz!=null){
		inOrden(raiz.getIzquierda());
		System.out.println(raiz.getDato());
		inOrden(raiz.getDerecha());
		}
}
public void posOrden(NodoBinario<T>raiz){
		if(raiz!=null){
		posOrden(raiz.getIzquierda());
		posOrden(raiz.getDerecha());
		System.out.println(raiz.getDato());
		}
}

public void crear(NodoBinario<T> raiz,String a){try{
	  String[] x=a.split("");
	  for(int i=0;i<=a.length();i++){
	  if(raiz.getDerecha()!=null&& raiz.getIzquierda()!=null){
		  if(x[i].equals("0")){
			    System.out.println("raiz izquierada = "+raiz.getDato());	
			    //raiz.setIzquierda(raiz.getDato());
		  		//crear(raiz.getIzquierda(),a); 
		  	}else if(x[i].equals("1")){
		  		System.out.println("raiz dererecha= "+raiz.getDato());	
		  		//crear(raiz.getDerecha(),a); 
		  	}	
	     }//cierre de if raiz Aquie se debe crear Nodos
	  //System.out.println("es nulo "+x[i]);
							  if(x[i].equals("0")){
							  		 //System.out.println("raiz i = "+raiz.getDato());
								  	  System.out.println("Se debe crear una rama izquieda "+x[i]);
								  	  NodoBinario I=new NodoBinario(x[i]);
								   	  raiz.setIzquierda(I);
								   	  //crear(raiz,a);
							  	}else if(x[i].equals("1")){
							  		  //System.out.println("raiz d= "+raiz.getDato());
							  		  System.out.println("Se debe crear una rama derecha "+x[i]);
							  		  NodoBinario D=new NodoBinario(x[i]);
							  		  raiz.setDerecha(D);
							  	}else{//System.out.println("raiz debe de ser "+x[i]);
							  		}
	  }//ciere de for
}catch(Exception x){}}
public void  recorrerC(String a){ 
	 NodoBinario R=new NodoBinario("raiz");ArbolBinario AB=new ArbolBinario();
   String[] x=a.split("");boolean sts=true;
   for(int i=0;i<a.length();i++){	NodoBinario N=new NodoBinario(x[i]);
      switch(x[i]){
        case "0"://N1.setIzquierda(N2);
       	 	if(R.getIzquierda()!=null){}else{R.setIzquierda(N);}
              System.out.println("Izquierda"); break;
        case "1":
       	 if(R.getDerecha()!=null){}else{R.setDerecha(N);}
               System.out.println("Derecha");break;
        case "|":
               if(x[i-1].equals("|")){System.out.println("arbol creado con exito");} break;
        case "-":
                System.out.println("crear un Nodo para "+x[i+1]);break;
        }
      // System.out.println(i+"°- "+x[i]);
   }
   AB.preOrden(R);
}
public void creaArbol(String Cadena){
	 NodoBinario nuevo=new NodoBinario(Cadena); char c;
	 char arra[];int x=0;
	 arra=new char[Cadena.length()];
     while(x<=Cadena.length()-1){
      c=Cadena.charAt(x);	}	
	for(int i=0;i<10;i++){
			NodoBinario inicio=new NodoBinario(i);
		if(nuevo.getIzquierda()!=null){
			nuevo.setDerecha(nuevo);
		}else if(nuevo.getDerecha()!=null){
			nuevo.setDerecha(nuevo);}
		else{}
		}	
}

public static void main(String []args){
		ArbolBinario AB=new ArbolBinario();
		NodoBinario N1=new NodoBinario("raiz");
		/**
		 *
		
		NodoBinario N2=new NodoBinario(null);
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
		 */
		
		//AB.recorrerC("000-l001-o01-a100-h010-.111- ||");
		NodoBinario R=new NodoBinario("raiz");
		AB.crear(R,"000-l001-o01-a100-h101-.111- ||");
		AB.preOrden(R);
		AB.recorrer();
		//System.out.println("preOrden:");
		//AB.preOrden(N1);
		//System.out.println("inOrden:");
		//AB.inOrden(N1);
		//System.out.println("preOrden:");
		//AB.posOrden(N1);
		}
}

/**
 * for(int i=0;i<a.length();i++){
		//System.out.println("x="+x[i]);
	while(raiz!=null){
		System.out.println("es diferente de nulo");
	if(x[i].equals("0")){
		
	//preOrden(raiz.getIzquierda());
		//crear(raiz.getIzquierda(),a);
	}else if(x[i].equals("1")){
		
	//preOrden(raiz.getDerecha());
		//crear(raiz.getDerecha(),a);
		}
	else if(x[i].equals("-")){
					System.out.println("\t\tagregar elemento "+x[i+1].toUpperCase());
	}else if(x[i].equals("|")&&(x[i-1].equals("|"))){
		System.out.println("Arbol creado con esxito");
	}
	if(x[i].equals("0")){
		System.out.println("crear Izquierda");
		NodoBinario Nuevo=new NodoBinario("¿I?");
		raiz.setIzquierda(Nuevo);
		
	}else if(x[i].equals("1")){ System.out.println("crear derecha");
	NodoBinario Nuevo=new NodoBinario("¿D?");
	raiz.setDerecha(Nuevo);
	
	}
	}
	}
 */
