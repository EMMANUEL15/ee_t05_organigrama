package ArbolAVL;
/**
* ARBOL BINARIO DE BUSQUEDA
* @author EMMANUEL
*/
public class Arbol_AVL<T extends Comparable<T>>{
  public NodoArbol<T> ArbolA;
  String titulo[]={"contenido de Arbol:","Busqueda de un nodo del Arbol: ", "elimainacion de un nodo del Arbol: ","contenido de Arbol depues eliminacion del nodo "};
  public Arbol_AVL(){}
  public void Datos(T dato){
      NodoArbol<T> N=new NodoArbol<T>(dato);
      RecorrerArbolA(ArbolA);
  }
  public void RecorrerArbolA(NodoArbol<T> raiz){ //RECORRE AL ArbolA 
    if(raiz!=null){
       System.out.println(raiz.ToString());
       RecorrerArbolA(raiz.getIzquierda());
       RecorrerArbolA(raiz.getDerecha());
        }
        }
  public void  crearA(T dato){
        crear(dato,ArbolA);
  }
	/**
		* METODOS DE PRUEBA...
		* SE AGRAGAN LOS DATOS AL ARBOL (A,B,C,D,E,F,G,H,I,J,K,L).
		* SE BUSCA LA LETRA "F" EN EL ARBOL SI EXISTE REGRESA UN MENSAJE EN CASO CONTRARIO REGRASA OTRO MENSAJE.
		* SE ELIMINA EL NODO QUE CON TINE LA LETRA "C" EN CASO QUE NO SEA ENCONTRADA REGRESA UN MENSAJE.
		* EN CADA OPERACION REALIZADA SE HACE UN RECORRIDO AL ARBOL PARA PODER APRECIAR LAS ALTERACIONES QUE SE REALIZA EN EL ARBOL.
	*/ 
  public void principal(){
      incertar((T)"L");
      incertar((T)"K");
      incertar((T)"J");
      incertar((T)"I");
      incertar((T)"H");
      incertar((T)"G");
      incertar((T)"F");
      incertar((T)"E");
      incertar((T)"D");
      incertar((T)"C");
      incertar((T)"B");
      incertar((T)"A");
      
      Title(0);
      RecorrerArbolA(ArbolA);
      
      Title(1);
      buscar(ArbolA,(T)"5");
	  buscar(ArbolA,(T)"F");
      
      Title(2);
      EliminarNodo(ArbolA,ArbolA,(T)"C");
      
      Title(3);
      RecorrerArbolA(ArbolA);
       
    }
	/**
		*METODO COMO DE PARTIDA DEL PROGRAMA.
		*LLAMA AL METODO PRINCIPAL QUE CONTINE LOS DATOS QUE SERAN UTILZADOS.
	*/
  public static void main(String [] args ){
     Arbol_AVL b=new Arbol_AVL();
     b.principal();
    }
	/**
		*METODO RECIBE UN DATO PARA PARA INCERTAR EN EL ARBOL LO CUAL LO ENVIA LA CONTRUCTOR CREAR
		*REVISA QUE ARBOL ESTE EQUILIBRADO LLAMADO AL METODO REVISAR
	*/
  public void incertar(T dato){
      crear(dato,ArbolA);   
      revisar(ArbolA,ArbolA);
  }
	 /**
   * este metodo recibe el dato del constructor incretar para crear un nodo 
   * recorre al arbol buscando la posicion que le corresponde la imformacion recibida, si la informacon es es mayor que el dato de un nodo avanza el lado derecho
   * si es menor avenza el lado izaquierdo, en caso que un nodo para avanzar crea un nodo con la informacion recibida.
   * si ya existe un Nodo con la misma informacion recibida no realiza ningun cambio al arbol
   */
  private void  crear(T dato,NodoArbol<T> raiz){
    NodoArbol<T> N=new NodoArbol<T>(dato); int r=0;
    if(raiz==null){
        ArbolA=N;
    } else{
        r=N.getDato().compareTo(raiz.getDato());
    }
    if(r>0){ //************ DERECHA 
            if(raiz.getDerecha()!=null){    // SI TIENE NODO DERECHA AVANZAR
                raiz.getDerecha();
                crear(dato, raiz.getDerecha());
            }else{                          // SI NO CREAR UN NODO DERECHA 
                raiz.setDerecha(N);
                Nivel(ArbolA);
            }
    }else if(r<0){//********** IZAQUIERDA
            if(raiz.getIzquierda()!=null){      // SI TIENE NODO IZAQUIERDA AVANZA AL NODO
                raiz.getIzquierda();
                crear(dato, raiz.getIzquierda());
            }else{                              // SI NO CREA UN NODO DERECHA 
                raiz.setIzquierda(N);
                Nivel(ArbolA);
            }
    }
   }
	 /**
    * este contructor realiza un recorrido al arbol refrescando los datos de equilibio del arbol
    * si el nodo no tienes ramas es cero, en caso que tenga un SubNodo toma el equilibrio mas uno para su equilibrio
    * si el Nodo tiene Subnodos de Ambos lados toma como base la ramas conequilibio mayor mas uno para su equilibrio
    */
  public void Nivel(NodoArbol<T> raiz){
     if(raiz!=null){
       Nivel(raiz.getIzquierda());
       Nivel(raiz.getDerecha());
       if(raiz.getIzquierda()==null&& raiz.getDerecha()==null){
                raiz.setEq(0);
       }else if(raiz.getIzquierda()!=null&& raiz.getDerecha()!=null){
           if(raiz.getIzquierda().getEq()>raiz.getDerecha().getEq()){
              raiz.setEq(raiz.getIzquierda().getEq()+1);
            }else{
              raiz.setEq(raiz.getDerecha().getEq()+1);
            }
       }else if(raiz.getIzquierda()!=null&& raiz.getDerecha()==null){
                raiz.setEq((raiz.getIzquierda().getEq()+1));
       }else if(raiz.getIzquierda()==null&& raiz.getDerecha()!=null){
                raiz.setEq((raiz.getDerecha().getEq()+1));
       }
        }
    }
  /**
     * este contructor recorrer al arbol analizando que no este desequilibrado
     * si el arbol presenta un desequilibrio llama a uno de los cotructores para rotar lo segun sea el caso
     * la roracion se realiza cuando de un lado tiene mas de uno nodo que del otro lado. lo cual se realiza dos tipos de de rotaciones dobles y sencillos
     */
  public void revisar(NodoArbol<T> raiz,NodoArbol<T> rz){
     if(raiz!=null){
       revisar(raiz.getIzquierda(),raiz);
       revisar(raiz.getDerecha(),raiz);
        if(raiz.getIzquierda()!=null&& raiz.getDerecha()!=null){
         int res=0;
         if((raiz.getIzquierda().getEq())>(raiz.getDerecha().getEq())){
            res=((raiz.getIzquierda().getEq())-(raiz.getDerecha().getEq()));
         }else{
            res=(raiz.getDerecha().getEq())-(raiz.getIzquierda().getEq());
          } 
         if(res>=2){
            if(raiz.getDato().compareTo(ArbolA.getDato())==0){
                    ArbolA=DobleD(raiz);
                    Nivel(ArbolA);
                } else{
                    if((raiz.getDerecha().getEq()>(raiz.getIzquierda().getEq()))){
                    rz.setDerecha(DobleD(raiz));
                    }else{
                    rz.setIzquierda(DobleD(raiz));
                }
                    Nivel(ArbolA);
                }
            }
       }else if(raiz.getIzquierda()!=null&& raiz.getDerecha()==null){
            if(raiz.getIzquierda().getIzquierda()!=null){
                 if(raiz.getDato().compareTo(ArbolA.getDato())==0){
                    ArbolA=II(raiz);
                    Nivel(ArbolA);
                } else{
                    rz.setIzquierda(II(raiz));
                    Nivel(ArbolA);
                }
            }else if(raiz.getIzquierda().getDerecha()!=null){
                if(raiz.getDato().compareTo(ArbolA.getDato())==0){
                    ArbolA=ID(raiz);
                    Nivel(ArbolA);
              } else{ 
                    rz.setIzquierda(ID(raiz));
                    Nivel(ArbolA);
              }
            }
       }else if(raiz.getIzquierda()==null&& raiz.getDerecha()!=null){ /////////ROTACION***********ROTACION *****RPOTACION  DEARECHA////
         if(raiz.getDerecha().getDerecha()!=null){
                if(raiz.getDato().compareTo(ArbolA.getDato())==0){
                    ArbolA=DD(raiz);
                } else{
                    rz.setDerecha(DD(raiz));
                    Nivel(ArbolA);
                }
         }else if(raiz.getDerecha().getIzquierda()!=null){
             System.out.println("rotar Dizq "+raiz.getDato());
            if(raiz.getDato().compareTo(ArbolA.getDato())==0){
                    ArbolA=DI(raiz);
              } else{
                    rz.setDerecha(DI(raiz));
                    Nivel(ArbolA);
              }
            }
       }
        }
      }
	/**
   * rotacion sencilla de lado derecho 
   */
  public NodoArbol<T> DD(NodoArbol<T> raiz){//  ROTACION DE LOS NODOS DERECHOS
     NodoArbol<T> aux1=new NodoArbol<T>(raiz.getDato()); 
     NodoArbol<T> aux2=raiz.getDerecha();
     aux2.setIzquierda(aux1);
     return aux2;
    }
	/**
    * rotacion sencilla de lado derecho
    */
  public NodoArbol<T> II(NodoArbol<T> raiz){//ROTACION DE NODO IZQUIERDO
     NodoArbol<T> aux1=new NodoArbol<T>(raiz.getDato()); 
     NodoArbol<T> aux2=raiz.getIzquierda();
     aux2.setDerecha(aux1);
     return aux2;
    }
	/**
     * rotacion doble
     * se realiza cuando tiene Subnodos con mas SubNodo, lo cual es mecesario respaldar algunos nodos y acomodar de forma concruente los nodo duante la rotacion
     * en este caso se puede realizar dos formas segun el lado que este mas cargado.
     */
  public NodoArbol<T> DobleD(NodoArbol<T> raiz){// ROTACION DOBLE
    NodoArbol<T> R=raiz;
    if((raiz.getIzquierda().getEq())>(raiz.getDerecha().getEq())){
     NodoArbol<T> aux1=new NodoArbol<T>(raiz.getDato());
     aux1.setDerecha(raiz.getDerecha());
     aux1.setIzquierda(raiz.getIzquierda().getDerecha());
     NodoArbol<T> aux2=new NodoArbol<T>(raiz.getIzquierda().getDato());
     aux2.setIzquierda(raiz.getIzquierda().getIzquierda());
     aux2.setDerecha(aux1);
     R=aux2;
   }else{
     System.out.println(raiz.getDato());
     NodoArbol<T> aux1=new NodoArbol<T>(raiz.getDato()); 
     aux1.setIzquierda(raiz.getIzquierda());
     aux1.setDerecha(raiz.getDerecha().getIzquierda());
     NodoArbol<T> aux2=new NodoArbol<T>(raiz.getDerecha().getDato());
     aux2.setDerecha(raiz.getDerecha().getDerecha());
     aux2.setIzquierda(aux1);
     R=aux2 ;
    }
   return R;
   }
	/**
    * se raliza un rotacion sencilla cuando cuando en nodo derecho no tiene nodo derecho pero tiene un nodo izquierdo
    */
  public NodoArbol<T> DI(NodoArbol<T> raiz){ //         ROTACION DE LOS NODOS DERECHOS E IZQUIERDOS
      NodoArbol<T> aux1=new NodoArbol<T>(raiz.getDato());
      NodoArbol<T> aux3=new NodoArbol<T>(raiz.getDerecha().getDato());
      NodoArbol<T> aux2=raiz.getDerecha().getIzquierda();
      aux2.setIzquierda(aux1);
      aux2.setDerecha(aux3);
      return aux2;
    }
	/**
    * se raliza un rotacion sencilla cuando cuando en nodo derecho no tiene nodo derecho pero tiene un nodo izquierdo
    */
  public NodoArbol<T> ID(NodoArbol<T> raiz){ //         ROTACION DE LOS NODOS IZQUIERDOS y DERECHOS
      NodoArbol<T> aux1=new NodoArbol<T>(raiz.getDato());
      NodoArbol<T> aux2=new NodoArbol<T>(raiz.getIzquierda().getDato());
      NodoArbol<T> aux3=raiz.getIzquierda().getDerecha();
      aux3.setIzquierda(aux2);
      aux3.setDerecha(aux1);
      return aux3;
    }
  /**
   * recibe un dato
   * recorre al arbol buscando el dato recibido. si el dato es mayor va al derecha en caso contrio a la izquierda
   * si la informacion existe guarda un mensaje si no guarda otro mensaje.
   */
  public void buscar(NodoArbol<T> raiz, T dato){
      if (raiz != null){
          if (dato.compareTo(raiz.getDato()) < 0){ // Vamos por la izquierda
                buscar(raiz.getIzquierda(), dato);
          }else if (dato.compareTo(raiz.getDato()) > 0){ // Vamos por la derecha
                buscar(raiz.getDerecha(), dato);
          }else{
                System.out.println("El objeto "+dato+" se encontró el en arbol.");
                Nivel(ArbolA);
                revisar(ArbolA,ArbolA);
            }
       }else{
            System.out.println("No se encontró el objeto "+dato);
       }
     }
   /**
   * SE PASA EN EN PARAMETRO EL ARBOL QUE SE DESEA ELIMINAR EL NODO Y EL DATO DEL NODO QUE SE DESEA ELMINAR.
   * RECORRER AL ARBOL BINARIO BUSACANDO EL NODO QUE CONTENGA EL DATO QUE SE DESAE ELIMINAR
   * SI EL NODO ENCONTRADO ES DE NODO HOJAS ES ELIMINDO POR EL MISMO COSTRUCTOR
   * SI EL NODO ES EL NODO PRINCIPAL LLAMA AL CONTRUCTOR NEWNODOP PARQ QUE LO ELIMINE
   * SI ES UN NODO INTERMEDIO QUE CONTINE LOS DOS NODOS O UNO LLAMA AL CONSTRUCTOR NEWNODOP SOBRECARGADO.
   * SI TEMINA EL RECOCORRIDO Y NO ENCUENTRA UN NODO CON EL DATO IMPRIME UN MENSAJE QUE NO HA SIDO ENCONTRADO.
   */
  public void EliminarNodo(NodoArbol<T> raiz,NodoArbol<T> rz, T dato){
      if (raiz != null){
          if (dato.compareTo(raiz.getDato()) < 0){ // Vamos por la izquierda
                EliminarNodo(raiz.getIzquierda(),raiz, dato);
          }else if (dato.compareTo(raiz.getDato()) > 0){ // Vamos por la derecha
                EliminarNodo(raiz.getDerecha(),raiz, dato);
          }else{ //ELIMANACION
              System.out.println("El objeto "+dato+" ha sido eliminado en el arbol.  ");
              if(ArbolA.getDato().compareTo(dato)==0){  
                 
                 if(ArbolA.getIzquierda()!=null||ArbolA.getDerecha()!=null){
                   NodoArbol<T> aux2;  NodoArbol<T> aux3; NodoArbol<T> aux1=null; 
                   if(ArbolA.getIzquierda()!=null){
                      aux2=ArbolA.getIzquierda(); 
                      aux1=new NodoArbol<T>(raiz.getIzquierda().getDato());
                       if(ArbolA.getIzquierda().getIzquierda()!=null){
                         aux1.setIzquierda(ArbolA.getIzquierda().getIzquierda());
                      }else{aux1=null;}
                    }else{aux2=null;}
                   if(ArbolA.getDerecha()!=null){
                       aux3=ArbolA.getDerecha();
                    }else{aux3=null;}
                   NEWNODOP(aux2,aux3,aux1);//eliminar nodo principal
                }else{
                   ArbolA=null;
                }
            }else if(rz.getDerecha()!=null&& rz.getDerecha().getDato().compareTo(raiz.getDato())==0){//DERECHO
                 if(raiz.getDerecha()==null&&raiz.getIzquierda()==null){
                   rz.setDerecha(null);
                 }else if(raiz.getDerecha()!=null&&raiz.getIzquierda()!=null){
                   NodoArbol<T> aux2=raiz.getIzquierda();  
                   NodoArbol<T> aux3=raiz.getDerecha();
                   NEWNODOP(aux2,aux2,aux2,aux3,rz,1);
                 }else if(raiz.getDerecha()!=null&&raiz.getIzquierda()==null){
                   rz.setDerecha(raiz.getDerecha());
                 }else if(raiz.getDerecha()==null&&raiz.getIzquierda()!=null){
                    rz.setDerecha(raiz.getIzquierda());
                 }
                }else if(rz.getIzquierda()!=null&&rz.getIzquierda().getDato().compareTo(raiz.getDato())==0){//IZQUIERDO
                  if(raiz.getDerecha()==null&&raiz.getIzquierda()==null){
                  rz.setIzquierda(null);
                 }else if(raiz.getDerecha()!=null&&raiz.getIzquierda()!=null){
                     NodoArbol<T> aux2=raiz.getIzquierda();  
                     NodoArbol<T> aux3=raiz.getDerecha();
                     NEWNODOP(aux2,aux2,aux2,aux3,rz,0);
                 }else if(raiz.getDerecha()!=null&&raiz.getIzquierda()==null){
                   rz.setIzquierda(raiz.getDerecha());
                 }else if(raiz.getDerecha()==null&&raiz.getIzquierda()!=null){
                   rz.setIzquierda(raiz.getIzquierda());
                 }
              }
            }
       }else{
            System.out.println("No se encontró el objeto "+dato);
       }
  }
  /**
   * ELIMINA LOS NODOS INTERMEDION 
   * SI EL NODO TINE RAMAS EXTENSA RECORRE LA RAMA IZQUIERDA PARA TOMAR EL ULTIMO NODO DERECHO DE ESA RAMA PARE REMPLAZAR CON EN NODO PRINCIPAL
   * SI SOLO TIENE DOS NODOS HOJAS TOMA LA RAMAS IZQUIERA PARA REMPLAZAR AL NODO PRINCIPAL
  */
  public void NEWNODOP(NodoArbol<T> nodo1,NodoArbol<T> nodo2,NodoArbol<T> nodoI,NodoArbol<T> nodoD,NodoArbol<T> nodoP,int id){// ELIMINACION DE NODOS INTEMEDIOS
    if(nodoI.getIzquierda()==null&&nodoI.getDerecha()==null&&nodoD.getIzquierda()==null&&nodoD.getDerecha()==null){ //nodo intemedio con dos hojas
        nodoI.setDerecha(nodoD);
        if(id==1){nodoP.setDerecha(nodo1);}else{nodoP.setIzquierda(nodo1);}
    } else if(id==1){//derecha
      if(nodo1.getIzquierda()!=null&&nodo1.getDerecha()!=null){
         NEWNODOP(nodo1.getDerecha(),nodo1,nodoI,nodoD,nodoP,id);
      }else if(nodo1.getIzquierda()==null&&nodo1.getDerecha()==null){
         if(nodo1.getDato().compareTo(nodoI.getDato())==0){
            nodoI.setDerecha(nodoD);
            nodoP.setDerecha(nodoI);
         }else{
         nodo1.setIzquierda(nodoI);
         nodo1.setDerecha(nodoD);
         nodo2.setDerecha(null);
         nodoP.setDerecha(nodo1);
        }
      }else if(nodo1.getDerecha()!=null&&nodo1.getIzquierda()==null){
         NEWNODOP(nodo1.getDerecha(),nodo1,nodoI,nodoD,nodoP,id);
      }else if(nodo1.getIzquierda()!=null&&nodo1.getDerecha()==null){
         nodo1.setDerecha(nodoD);
         nodoP.setDerecha(nodo1);
      }
    }else if(id==0){//izquierda
       if(nodo1.getIzquierda()!=null&&nodo1.getDerecha()!=null){
         NEWNODOP(nodo1.getDerecha(),nodo1,nodoI,nodoD,nodoP,id);
      }else if(nodo1.getIzquierda()==null&&nodo1.getDerecha()==null){
         if(nodo1.getDato().compareTo(nodoI.getDato())==0){
            nodo1.setDerecha(nodoD.getIzquierda());
            nodoD.setIzquierda(nodo1);
            nodoP.setIzquierda(nodoD);
         }else{
             nodo1.setIzquierda(nodoI);
             nodo1.setDerecha(nodoD);
             nodo2.setDerecha(null);
             nodoP.setIzquierda(nodo1);
        }
      }else if(nodo1.getDerecha()!=null){
         NEWNODOP(nodo1.getDerecha(),nodo1,nodoI,nodoD,nodoP,id);
      }else if(nodo1.getIzquierda()!=null){
         nodo1.setDerecha(nodoD);
         nodoP.setIzquierda(nodo1);
      }
    }
  }
	/**
		* ELIMINA EL NODO PRINCIPAL
		* RECORRE LA RAMA IZAQUIERDA PARA BUSCAR UN LO CUAL REMPLAZAR CON EL NODO PRINCIPAL
	*/
    public void NEWNODOP(NodoArbol<T> raiz,NodoArbol<T> D,NodoArbol<T> DI){ //ELIMINACION DE NODO PRINCIPAL
    NodoArbol<T> aux=new NodoArbol<T>(raiz.getDato());
    System.out.println("  "+aux.getDato());
    if(raiz.getDerecha()!=null){
       System.out.println(raiz.ToString());
       NEWNODOP(raiz.getDerecha(),D,DI);
    }else{
           aux.setDerecha(D);
           aux.setIzquierda(DI);
           ArbolA=aux;
        }
  }
	/**
		*titulo de la operaciones realizadas
	*/
  public void Title(int i){
	System.out.println("\n\n");
	for(int z=1;z<=40;z++){
		System.out.print("****");
		if(z==20){System.out.println("\n\t\t"+titulo[i]);}
	}
	System.out.println();
	}
  }