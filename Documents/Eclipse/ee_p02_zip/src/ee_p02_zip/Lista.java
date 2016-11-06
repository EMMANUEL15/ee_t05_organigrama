package ee_p02_zip;

/**
 * @author EMMANUEL
 */
public class Lista<T>
{
    public String Mensaje;
    public String Arbol;
    public String MSMcomprimido;
    public int idfault=0;
    public Nodo<T> Frecuencia;
    NodoBinario2 n1=new NodoBinario2();//NODO TEMPORAL
    NodoBinario2 n2=new NodoBinario2();//NODO TEMPORAL
    NodoBinario2 R=new NodoBinario2();//NODO PRICIPAL(raiz)
   /**
    * INCETAR UN NODO AL INICIO SIN SUBNODOS
    */
   public void inserta_inicio(NodoBinario2<T> dato){
        Nodo<T> N=new Nodo<T>(dato);
        N.setSiguiente(Frecuencia);
        Frecuencia=N;
    }
    /**
    * INCETAR UN NODO AL FINAL SIN SUBNODOS
    */
    public void inserta_final(NodoBinario2<T> dato){
     try{
       Nodo<T> var=Frecuencia;
       while((var.getSiguiente())!=null){
           var=var.getSiguiente();
        }
        Nodo<T> N=new Nodo<T>(dato);
        var.setSiguiente(N);
        var=null;
       }catch(Exception e){}
   }
    /**
    * RECORER LA LISTA DE PRIORIDAD
    */
     public void recorrer(){
         Nodo<T> F =Frecuencia;
        while(F!=null){
         F=F.getSiguiente();
             }
   }
   /**
    * CREA UN ARBOL POR PRIORIDAD
    * Crea nodos con dato null con frecuencia de la suma de frecuencia de las dos subnodos
    */
   public void creE(){ 
        Nodo<T> F =Frecuencia; int c=3; int suma=0; boolean sts=true;Nodo<T> z =    null;
        while(F!=null){
          if(Frecuencia!=null){
            z=F.getSiguiente();
            Frecuencia = z.getSiguiente();
            }
           NodoBinario2<T> uno=F.getDat();
           NodoBinario2<T> dos=F.getSiguiente().getDat();
           suma=F.getDat().getP()+F.getSiguiente().getDat().getP();
           NodoBinario2 n3=new NodoBinario2();
           n3.NodoBinarioc(null,suma,uno,dos);
           OrdenadorPa(n3);
           R.NodoBinarioc(null,suma,uno,dos);
           c++;recorrer();
           F=F.getSiguiente(); F=F.getSiguiente();
             } 
    }
    /**
     * Recibe un Nodo binario recorre a la lista de de prioridad para hubicar la posicion que pertenece el nodo.
     * si en la prioridad es igual o menor envia el nodo con una refrencia al contructor incertar antes o incertar depues.
     * en caso que nosdo sea mayor que que todo los nodo los nodo de la lista se envia al contructor incertar al final.
     */
   public void OrdenadorPa(NodoBinario2<T> dato){//RECIBE NODO Y LO ORDENA DE ACUERDO A SU PRIORIDAD
       Nodo<T> aux=Frecuencia; int pos=0; boolean sts=false;
       while(aux!=null){
           if(dato.getP()>aux.getDat().getP()){                 //avanzar si la prioridad es mayor
               aux=aux.getSiguiente();
            }else{
              sts=true;
              int r=aux.getDat().getP();
                if(dato.getP()==aux.getDat().getP()){           //si la prioridad de nodo es igual que la referencia 
                I_despues(dato,r);
                break;
              }else if(dato.getP()<aux.getDat().getP()){        ////si la prioridad de nodo es mayor que la referencia 
                I_antes(dato,r);
                break;
              }
            }
        }
        Nodo<T> D =Frecuencia;
       if(sts==false){  //en casa que la priordad del Nodo es mayor que todo los Nodos almacenados en la lista incertarlo al final
          if(D!=null){
                  inserta_final(dato);
          }
        }
    }
    /**
     * recibe un nodo Binario con una referencia de entero 
     * recorrer la lista de prioridades al encontrar un nodo con la prioridad con la referencia.
     * incerta en nodoBinario antes de la referancia.
     */
    public void I_antes(NodoBinario2<T> dato,int Referencia){// INCERTAR DATO ANTES DE LA REFERENCIA
      Nodo<T> aux=Frecuencia; Nodo<T> z=null;    Nodo<T> tem=null;int con=0;
      Nodo<T> N=new Nodo<T>(dato);
      while(aux!=null){
        z=aux.getSiguiente();
        con++;
        if(aux.getDat().getP()==(Referencia)){
          if(con==1){
                Nodo<T> Z=new Nodo<T>(dato);
                Z.setSiguiente(Frecuencia);
                Frecuencia=Z;
            }else{
                aux.setSiguiente(tem);
                tem.setSiguiente(N);
                N.setSiguiente(aux);
                aux.setSiguiente(z);break;
              }
          }
           tem=aux;   aux=aux.getSiguiente();
        }
   }
    /**
     * recibe un nodo Binario con una referencia de entero 
     * recorrer la lista de prioridades al encontrar un nodo con la prioridad con la referencia.
     * incerta en nodoBinario depues de nodo la referancia encontrada.
     */
   public void I_despues(NodoBinario2<T> dato,int Referencia){//INCERTAR DATO DESPUES DE LA REFERENCIA
     try{
         Nodo<T> aux=Frecuencia;    Nodo<T> tem=null;  Nodo<T> N=new Nodo<T>(dato);//Nodo<T> z=null;
       while(aux!=null){
          if(aux.getDat().getP()==(Referencia)){
              Nodo<T> z=aux.getSiguiente();
               aux.setSiguiente(N);
               N.setSiguiente(z);break;
            }
          aux=aux.getSiguiente();
        }
          }catch(Exception e){inserta_final(dato);}
       }
       /**
        * recibe nodo binario si nos ramas, recorrer la lista para ubicar la porsion que pertenece, si su prioridad es igual a menor envia el nosdo con una referncia 
        * string al los contructores de inceratar antes o despues en caso que la prioridad se mayor se esnnvia al contructor incertar al final.
        */
   public void Ordenador(NodoBinario2<T> dato){//RECIBE NODO Y LO ORDENA DE ACUERDO A SU PRIORIDAD
       Nodo<T> aux=Frecuencia; int pos=0; boolean sts=false;
       while(aux!=null){
           if(dato.getP()>aux.getDat().getP()){					//avanzar si la prioridad es mayor
               aux=aux.getSiguiente();
            }else{
              sts=true;
              String r=(String)aux.getDat().getDato();
                if(dato.getP()==aux.getDat().getP()){			//si la prioridad de nodo es igual que la referencia 
                I_despues(dato,r);
                break;
              }else if(dato.getP()<aux.getDat().getP()){		////si la prioridad de nodo es mayor que la referencia 
                I_antes(dato,r);
                break;
              }
            }
        }
        Nodo<T> D =Frecuencia;
       if(sts==false){	//en casa que la priordad del Nodo es mayor que todo los Nodos almacenados en la lista incertarlo al final
          if(D!=null){
                  inserta_final(dato);
          }
        }
    }
    /**
     * constructor incertar antes sobrecargado con refrencia String.
     */public void I_antes(NodoBinario2<T> dato,String Referencia){// INCERTAR DATO ANTES DE LA REFERENCIA
      Nodo<T> aux=Frecuencia; Nodo<T> z=null;    Nodo<T> tem=null;int con=0;
      Nodo<T> N=new Nodo<T>(dato);
      while(aux!=null){
        z=aux.getSiguiente();con++;
        if(aux.getDat().getDato().equals(Referencia)){
          if(con==1){
                Nodo<T> Z=new Nodo<T>(dato);
                Z.setSiguiente(Frecuencia);
                Frecuencia=Z;
            }else{
                aux.setSiguiente(tem);
                tem.setSiguiente(N);
                N.setSiguiente(aux);
                aux.setSiguiente(z);
              }
          }
           tem=aux;   aux=aux.getSiguiente();
        }
   }
   /**
    * constructor incertar despues sobrecargado con refrencia String.
    */
   public void I_despues(NodoBinario2<T> dato,String Referencia){//INCERTAR DATO DESPUES DE LA REFERENCIA
     try{
         Nodo<T> aux=Frecuencia; Nodo<T> z=null;   Nodo<T> tem=null;int con=0;  Nodo<T> N=new Nodo<T>(dato);
       while(aux!=null){
          z=aux.getSiguiente(); con++;
          if(aux.getDat().getDato().equals(Referencia)){
               aux.setSiguiente(N);
               N.setSiguiente(z);
            }
          aux=aux.getSiguiente();
        }
          }catch(Exception e){inserta_final(dato);}
       }
   /**
    * recibe el texto
    * recorre al texto contanto la fercuencia de los caractres que son contenidos en el texto
    * crea un nodos con los datos del texto 
    * tomando un caracte como dato y su frcuencia como prioridad lo envia al ordenodor.
    */
   public void LeerMsj(String msj,int i){
       this.Mensaje=msj; boolean sts=true;
       String [] c=msj.split(""); int frecuencia=0;
       for(int j=0;j<msj.length();j++){
          if(c[i].equals(c[j])){
            frecuencia++;
             }
            }
       NodoBinario2 ms=new NodoBinario2(); 
       ms.NodoBinarioc(c[i],frecuencia,null,null); 
       Nodo<T> var=Frecuencia;
       if(i==0&&var==null){
           inserta_inicio(ms);sts=false;
        }else{
           while(var!=null){
             if(c[i].equals(var.getDat().getDato())){
                 sts=false;
                  }
             var=var.getSiguiente();
                  }
        }
       if(sts==true){Ordenador(ms);}
        i++;frecuencia=0;
       if(i<msj.length()){LeerMsj(msj,i);}
       else{principal();}
    }
    /**
     * hace un recorrido al Arbol creado de manera preOrdinaria.
     */
   public void RecorrerArbol(NodoBinario2<T> raiz){ //RECORRE AL ARBOL 
            if(raiz!=null){
                //System.out.println(raiz.ToString());
                RecorrerArbol(raiz.getIzquierda());
                RecorrerArbol(raiz.getDerecha());
            }
        }
    /**
     * Comvierte el mensaja recibido a bienarinario para Mostrar el tamaño del archivo
     */
    public  void convers (String msj){
        Pantalla p=new Pantalla();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
      this.Mensaje=msj; 
      String letras =Mensaje, n,z="";
		int x=0,separador=0;
      for (int i=0; i<letras.length(); i++){
       x=letras.charAt(i);
       n=Integer.toBinaryString(x);
       char [] b;b=n.toCharArray();
       if(b.length==6){
          n=String.valueOf(0+n);
        }
       z=String.valueOf(z+"  "+n);
       separador++;
       if(separador==10){
           z=String.valueOf(z+"\n");
           separador=0;}
      }
      p.dato(z);
      p.datB(Mensaje);
   }
   /**
    * recorre al para crear una cadena cola cual se usara para crea el mismo arbol y poder leer en mensaje
    */
   public void armar(NodoBinario2<T> raiz,int z,String n) {
       String N=n;
       if(raiz!=null){
           if(raiz.getDato()!=null& z!=0){ Arbol= ""+Arbol+n+"-"+raiz.getDato();  }
           if(raiz.getIzquierda()!=null){
                n=String.valueOf(n+0);   armar(raiz.getIzquierda(),1,n);
            }
            n=N;
           if(raiz.getDerecha()!=null){
                n=String.valueOf(n+1);  armar(raiz.getDerecha(),1,n);
            }
            }
        }
    /**
    * recorre la cadena para hacer un mensaje comprimido 
    */
    public void Comprimir(int z,String MSM){
      String [] Arr=Mensaje.split("");
      String [] c=Arbol.split("-");
	  for(int i=0;i<c.length;i++){
	   String []x=c[i].split("");
	   if(x[0].equals(Arr[z])){
	     if(c[i-1].equals(c[0])){
	         MSM=String.valueOf(MSM+c[0]);
	       }else{
	     String []m=c[i-1].split("");
	     for(int s=1;s<m.length;s++){
	       MSM=String.valueOf(MSM+m[s]);
	       }
	    }
	   } 
	   } 
	  z++;
	  if(z<Mensaje.length()){Comprimir(z,MSM);}
	  else{this.MSMcomprimido=MSM; }
   }
   public  void principal(){
        recorrer();
        creE();
        RecorrerArbol(R);
        armar(R,0,"");
        String [] c=Arbol.split("null");
        Arbol=String.valueOf(c[1]);
        Comprimir(0,"");
        Arbol=String.valueOf(c[1]+"||"+MSMcomprimido);
        Pantalla p=new Pantalla();ee_p02_Zip e=new ee_p02_Zip();
        p.dato(Arbol);
        e.TxGuardar(Arbol);
        p.setLocationRelativeTo(null);
        p.setVisible(true);
    }
    }
   
