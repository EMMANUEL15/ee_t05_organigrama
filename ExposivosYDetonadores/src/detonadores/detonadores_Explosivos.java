package detonadores;

public class detonadores_Explosivos
{
public int bombas,det,i=1;int z=70;
public NodoA Detonador;
public NodoA Explosivos;
public NodoA total;
private detonadores_Explosivos(){
    Explosivos=null;
    Detonador=null;
    total=null;
}
public NodoA getInicio(){
    return Detonador;
}
public void setInicio(NodoA ini){
    this.Detonador=ini;
}
public void BombasYdetonadores(int Bombas,int Detonador){
    this.det=Detonador;
    this.bombas=Bombas;
     for(int i=0;i<=30;i++){
      if(i<15){System.out.print("---");}
      else if(i==15){System.out.println("\n\t"+bombas+" Bombas y "+det+" Detonadores");}
      else{System.out.print("---");}
    }
    System.out.println();
}
public void AsignarP_Detonadores(){
    for(int i=1;i<=det;i++){
    NodoA A=Detonador;
    Integer num=(int)(Math.random()*det+1);
    if(A!=null){  
      while(A!=null){
        //System.out.println("\t["+A.ToString()+"]");
        if(Integer.parseInt(A.ToString())!=num){
           A=A.getSiguiente();
           }else{num=(int)(Math.random()*det+1); A=Detonador;}
           }
      System.out.println(i+"°- Detonador "+num);
      NodoA N=new NodoA(num);
      N.setSiguiente(Detonador);
      Detonador=N;
        }
    else{
      System.out.println(i+"°- Detonador "+num); 
      NodoA N=new NodoA(num);
      N.setSiguiente(Detonador);
      Detonador=N;
        }
       // NodoA N=new NodoA(num);  // N.setSiguiente(total);   //total=N;
	NodoA N=new NodoA(num);
    NodoA var=total;
		if(var!=null){
        while((var.getSiguiente())!=null){
           var=var.getSiguiente();
        }
          var.setSiguiente(N);
    }else{
          N.setSiguiente(total);
          total=N;
	}
}
}
public void AsignarP_B(){
    for(int i=1;i<=bombas;i++){
        NodoA B=Explosivos;
        Integer num=(int)(Math.random()*bombas+1);
        if(B!=null){  
            while(B!=null){
             //System.out.println("\t["+A.ToString()+"]");
             if(Integer.parseInt(B.ToString())!=num){
                    B=B.getSiguiente();
                }else{num=(int)(Math.random()*bombas+1); B=Explosivos;}
                }
            System.out.println(i+"°- Bomba "+num);
            NodoA N=new NodoA(num);
            N.setSiguiente(Explosivos);
            Explosivos=N;
        }
        else{
          System.out.println(i+"°- Bomba "+num); 
          NodoA N=new NodoA(num);
          N.setSiguiente(Explosivos);
          Explosivos=N;
        }
        NodoA N=new NodoA(num);
         NodoA var=total;
        while((var.getSiguiente())!=null){
           var=var.getSiguiente();
        }
          var.setSiguiente(N);
    }
}
public void recorrerCadaU(){
  for(int i=0;i<=z;i++){   // Titulo
      if(i<z/2){System.out.print("---");}
      else if(i==z/2){System.out.println("\n\t\t Explisivos y Detonadores por separado");}
      else{System.out.print("---");}
    }
  System.out.println();
  NodoA A=Detonador;NodoA B=Explosivos;
  while(A!=null){            //lista de los detonadores
    System.out.print(" ["+A.ToString()+"] ");
    A=A.getSiguiente();
  }
      System.out.print("\n");//separacion
  while(B!=null){            //  //lista de los Explosivos
    System.out.print(" ["+B.ToString()+"] ");
    B=B.getSiguiente();
    }
}
public void Posiciones(int p){
 NodoA A=Detonador; int i=1; NodoA B=Explosivos;
 while(A!=null){         
    if(Integer.parseInt(A.ToString())==p){System.out.print("El DETONADOR "+p+" esta en la posicion "+i);}
    A=A.getSiguiente();i++;
 }
 while(B!=null){      
     if(Integer.parseInt(B.ToString())==p){System.out.println(" y corresponde a la BOMBA "+p+" de la posicion "+i);}
    B=B.getSiguiente();i++;
    }
}
public void ListaC(){
  for(int i=0;i<=z;i++){   // Titulo
      if(i<z/2){System.out.print("---");}
      else if(i==z/2){System.out.println("\n\t\t Explisivos y Detonadores");}
      else{System.out.print("---");}
    }
  System.out.println(); NodoA C=total;
  while(C!=null){            //  //lista de los Explosivos
    System.out.print("["+C.ToString()+"] ");
    C=C.getSiguiente();
    }
	System.out.println();
}
public void Bombas_con_sus_respetivos_Detonadores(){
 for(int i=0;i<=z;i++){ // Titulo
      if(i<z/2){System.out.print("---");}
      else if(i==z/2){System.out.println("\n\t\tDETONADORES CON SUS RESPETIVOS EXPLOSIVOS");}
      else{System.out.print("---");}
    }
	System.out.println();
	for(int p=1;p<=det;p++){
	NodoA C=total; int i=1;
  while(C!=null){      
	 if(Integer.parseInt(C.ToString())==p&& i<=det){
		System.out.format("%10s %1s %1s %2s %2s  %-2s %1s","El Detonador [",C.ToString(),"]","","esta en la posiscion",i,"y");
	}else if(Integer.parseInt(C.ToString())==p&& i>det){
		System.out.format("%10s %1s %1s %2s %n"," corresponde a la Bomba [",C.ToString(),"] de la posiscion ",i);
    }
    C=C.getSiguiente();
    i++;
    }
 }
}
public void Buscar(int p){
  for(int i=0;i<=z;i++){  // Titulo
      if(i<z/2){System.out.print("---");}
      else if(i==z/2){System.out.println("\n\t\tRESULTADO DE LA BUSQUEDA DEL EXPLOSIVO Y DETONADOR "+p+"...");}
      else{System.out.print("---");}
    }
	System.out.println();
	NodoA C=total; int i=1;
  while(C!=null){      
	 if(Integer.parseInt(C.ToString())==p&& i<=det){
		System.out.print("El Detonador ["+C.ToString()+"] esta en la posiscion "+i+" y");
	}else if(Integer.parseInt(C.ToString())==p&& i>det){
		System.out.println("corresponde a la Bomba ["+C.ToString()+"] de a posiscion "+i);
    }
    C=C.getSiguiente(); i++;
    }
}
public static void main(String []args){
  detonadores_Explosivos d=new detonadores_Explosivos();
  d.BombasYdetonadores(10,10);    //Asignar la catidad de Explosivos y detonadores
  System.out.println("lista  de Detonadores"); 
  d.AsignarP_Detonadores();          // Asignar posiscion a los detonadores
  System.out.println("lista  de Explisivos"); 
  d.AsignarP_B();                    //Asignar posicion a los Explosivos
  
  System.out.println();
  d.recorrerCadaU();           //primera parte 
  System.out.println();
  d.Posiciones(3);

  System.out.println();
  d.ListaC();					// tercera y segunda 
  System.out.println();
  d.Bombas_con_sus_respetivos_Detonadores();

  System.out.println();
  d.Buscar(5);  
}
}