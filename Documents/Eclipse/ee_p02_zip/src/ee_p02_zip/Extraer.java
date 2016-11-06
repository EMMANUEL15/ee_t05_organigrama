package ee_p02_zip;

/**
 * @author EMMANUEL
 */
public class Extraer<T>{;
public String msmd;
public NodoBinario<T>raiz;
NodoBinario R=new NodoBinario(null);
public NodoBinario Nodo;
public String Mensaje,Arbol;
/**
 * Recibe la cadena de String como parametro, lo separa una parte para el Arbol y otra para el mensaje.
 * envia los datos separdado al contructos Arbol para crear el el arbol.
 * al terminar de enviar los datos llama al constructor leer para leer el mensaje.
 * @param cadena
 */
private void texto(String cadena){
	try{
	
	String[]t=cadena.split((String)("\\|\\|"));//separacion entre el arbol y texto
	this.Mensaje=t[1];			//parte del Mensaje
	this.Arbol=t[0];			//parte de Arbol
	String[] x=Arbol.split("-");//Separarar los caratere del Arbol
	 for(int i=0;i<x.length;i++){		//crear arbol
		Arbol(R,x[i],x[i+1],0);
	   }
}catch(Exception e){
	leer(R,0,"");		//LeerMensaje
   }
}
/**
 * recibe los como parametro los datos de constructor texto para crear el arbol.
 * separa el paque de indicadores para crear el abol, crea nodos de con infrmacion null excepto del ultimo indicador.
 * porteriormente regresa por otro paquete de indicadores  constructor texto y asi sucesivamente has que no haya mas paquetes.
 * @param raiz 	//como ubicacion 
 * @param s		//como paque de indicadores
 * @param dato	//informacion para el nodo
 * @param i 	//como posicion de indicador
 */
private void  Arbol(NodoBinario<T> raiz,String s,String dato,int i){
	String[] c=s.split("");// indicador
	String[] d=dato.split("");// dato para el nodo
	if(i+1==s.length()){Nodo=new NodoBinario(d[0]);}
	else{Nodo=new NodoBinario(null);} 	//1
	if(c[i].equals("1")){ //************ DERECHA 
		
			if(raiz.getDerecha()!=null){	// SI TIENE NODO DERECHA AVANZAR
				raiz.getDerecha();
			}else{							// SI NO CREAR UN NODO DERECHA 
				raiz.setDerecha(Nodo);
			}
							i++;						// SIGUIENTE INDICADOR
							if(i<s.length()){			// SI HAY MAS INDICADOR CICLAR SI NO TEMINAR
							Arbol(raiz.getDerecha(),s,dato,i);
						}
	}else if(c[i].equals("0")){//********** IZAQUIERDA
		
			if(raiz.getIzquierda()!=null){		// SI TIENE NODO IZAQUIERDA AVANZA AL NODO
				raiz.getIzquierda();
			}else{								// SI NO CREA UN NODO DERECHA 
				raiz.setIzquierda(Nodo);
			}
						i++;					//SIGUIENTE INDICADOR
						if(i<s.length()){ //	//SI HAY MAS INDICADOR CICLAR DE LO CONTRARIO TERMINAR
							Arbol(raiz.getIzquierda(),s,dato,i);
						}
	}else{ 	//******* ***** SI EL INDICADOR NO ES 1 NI 0 PASAR A LA SIGUIENTE 
		i++;	
		if(i<s.length()){ //	CICLAR SI HAY MAS INDICADOR EN CASO CONTRARIO TERMINAR;
			Arbol(raiz,s,dato,i);
		}
	}
}
/**
 * recibe como parametro los datos enviados del contructor texto, separa la informacion de la variable mensaje.
 * recorre al arbol segun los indocadores seprados de la varible.
 * imprime la informacion de nodo que es diferente de null.
 * @param raiz
 * @param i
 */
public void leer(NodoBinario<T> raiz,int i,String m){
	try{
	String[] c=Mensaje.split("");
	if(raiz.getDato()!=null){
		m=String.valueOf(m+raiz.getDato());
		if(i<Mensaje.length()){
			leer(R,i,m);
		}else{
			 this.msmd=m;
			 }
	}
	if(c[i].equals("1")){
		if(raiz.getDerecha()!=null){
			raiz.getDerecha();
			i++;
			if(i<Mensaje.length()){
				leer(raiz.getDerecha(),i,m);
			}else{
			 this.msmd=m;
			 }
		}//**(no)
	}else{
		if(raiz.getIzquierda()!=null){
			raiz.getIzquierda();
			i++;
			if(i<Mensaje.length()){
				leer(raiz.getIzquierda(),i,m);
			}else{
			 this.msmd=m;
			 }
		}//**(no)
	}
}catch(Exception e){}
}
/**
 * hace un recorrido total
 * @param raiz
 */
public void preOrden(NodoBinario<T> raiz){
	if(raiz!=null){
				System.out.println(raiz.getDato());
				preOrden(raiz.getIzquierda());
				preOrden(raiz.getDerecha());
			}
		}
public void ExtraerArchivo(String x){
	texto(x);
        Pantalla p=new Pantalla();ee_p02_Zip e=new ee_p02_Zip();
        e.TxGuardar(msmd);
        p.dato(msmd);
        p.setLocationRelativeTo(null);
        p.setVisible(true);
}
}