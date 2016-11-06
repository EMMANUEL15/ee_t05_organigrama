package Arbol;
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
   public void inserta_inicio(NodoBinario2<T> dato){//INCERAR NODO AL INICIO
        Nodo<T> N=new Nodo<T>(dato);
        N.setSiguiente(Frecuencia);
        Frecuencia=N;
    }
    public void inserta_final(NodoBinario2<T> dato){//INCERTAR NODO AL FINAL
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
     public void recorrer(){//RECORER LA LISTA DE PRIORIDAD
         Nodo<T> F =Frecuencia; boolean lista=false;
        while(F!=null){
         System.out.print("["+F.ToString()+"]-");
         F=F.getSiguiente();lista=true;
             }
        if(lista==false){System.out.println("VACIO!!");}
        System.out.println();  
   }
   public void creE(){  //Crear Albol Es posble
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
           //Ordenador(n3);
           OrdenadorPa(n3);
           R.NodoBinarioc(null,suma,uno,dos);
           c++;recorrer();
           F=F.getSiguiente(); F=F.getSiguiente();
             }
        System.out.println();  
    }
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
    }public void I_antes(NodoBinario2<T> dato,String Referencia){// INCERTAR DATO ANTES DE LA REFERENCIA
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
   public void LeerMsj(String msj,int i){///LEE MENSAJE ----> EJEMPO: HOLA ALO OLA HA HA,0
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
    }
   public void RecorrerArbol(NodoBinario2<T> raiz){ //RECORRE AL ARBOL 
            if(raiz!=null){
                System.out.println(raiz.ToString());
                RecorrerArbol(raiz.getIzquierda());
                RecorrerArbol(raiz.getDerecha());
            }
        }
    public  void convers (){
      String letras =Mensaje, n;
      System.out.println();int x=0,separador=0;
      for (int i=0; i<letras.length(); i++){
       x=letras.charAt(i);
       n=Integer.toBinaryString(x);
       char [] b;b=n.toCharArray();
       if(b.length==6){
          n=String.valueOf(0+n);
        }
       System.out.print(n+"  ");separador++;
       if(separador==10){System.out.println();separador=0;}
      }
   }
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
   public  void principal(){
        //this.Mensaje="HOLA ALO OLA HAHA.";
        this.Mensaje="la inteligencia consiste no solo en el conocimiento, sino tambien en la destreza de aplicar los conocimientos en la practica.";
        LeerMsj(Mensaje,idfault);
        //convers();
        System.out.println();
        recorrer();
        System.out.println();
        creE();
        RecorrerArbol(R);
        armar(R,0,"");
        String [] c=Arbol.split("null");
        Arbol=String.valueOf(c[1]);
        Comprimir(0,"");
        Arbol=String.valueOf(c[1]+"//"+MSMcomprimido);
        System.out.println("\nMensaje comprimido: "+Arbol);
    }
   public static void main(){Lista L=new Lista(); L.principal();} 
   public void ComprimirZ(){
      char [] Arr=Mensaje.toCharArray();
      String [] c=Arbol.split("-");
	  for(int i=0;i<Arr.length;i++){
	     System.out.print(Arr[i]);
	   }
	  System.out.println();
	  for(int i=0;i<c.length;i++){
	      System.out.print(c[i]+"--->");
	   }
   }
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
	  else{System.out.println("\n"+MSM);
	     this.MSMcomprimido=MSM;
	   }
   }
}