package ee_t05_organigrama;
public class Organigramas<T>{
    Informacion<T> Organigrama;
    public Organigramas(){ 
    	Organigrama=null;
    	}
    public Informacion<T> getOR()
    { 
    	return Organigrama; 
    	}
    public void setOR(Informacion<T> Organigrama)
    {
    	this.Organigrama=Organigrama;
    	}
    public void incertarRaiz(T dato)
    {
        Informacion<T> I=new Informacion<T>(dato);
        I.setSiguiente(Organigrama);
        Organigrama=I;
    }
    public void Recorrer(Informacion<T> raiz)
    {
        Informacion<T> D= raiz;
        while(D!=null)
        {
            System.out.println(D.ToString());
            D=D.getSiguiente();
        }
    }
    public void IncertarRama(Informacion<T> raiz,T dato,T refe)
    {
        Informacion<T> D= raiz;
        while(D!=null){
             System.out.println(D.ToString());
            if(D.getDato().equals(refe))
            {
                Hijos(D.getHijos(),dato);
                //break;
            }
            D=D.getSiguiente();
        }
    }
    public void Hijos(Lista<Informacion<T>> Hijos,T dato)
    {
        if(Hijos.getDI()!=null){

        }
        Informacion<T> N=new Informacion<T>(dato);
        Hijos.Incertar(N);
    }
    public void prueba()
    {
        incertarRaiz((T)"Direccion1");
        incertarRaiz((T)"Direccion2");
        IncertarRama(Organigrama,(T)"gerencial",(T)"Direccion2");
        Recorrer(Organigrama);
    }
    public static void main(String []args){
        Organigramas O=new Organigramas();
        O.prueba();
    }
}
