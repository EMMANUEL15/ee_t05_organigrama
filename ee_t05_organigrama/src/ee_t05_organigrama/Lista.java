package ee_t05_organigrama;
public class Lista<T>{
    Informacion<T> Diagrama;
    public Lista(){ Diagrama=null;}
    public Informacion<T> getDI(){ return Diagrama; }
    public void setDI(Informacion<T> Diagrama){this.Diagrama=Diagrama;}
    public T returnDato(){
        T r=(T)"";
        return r;
    }
    public void Incertar(T dato)
    {//incertar elemento en el inicio
        Informacion<T> N=new Informacion<T>(dato);
        N.setSiguiente(Diagrama);
        Diagrama=N;
    }
         public void Incertar(Informacion<T> N)
        {//incertar elemento en el inicio;
        N.setSiguiente(Diagrama);
        Diagrama=N;
    }
    public void reco(){
        Informacion<T> D= Diagrama;
        while(D!=null)
        {
            System.out.println(D.ToString());
            D=D.getSiguiente();
        }
    }
    public void prueba(){
        Incertar((T)"uno");
        Incertar((T)"dos");
        Incertar((T)"tres");
        reco();
    }
    public static void main(String [] args){
        Lista L=new Lista();
        L.prueba();
    }
}
