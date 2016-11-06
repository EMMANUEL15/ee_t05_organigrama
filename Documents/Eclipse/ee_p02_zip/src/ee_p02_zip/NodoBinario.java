package ee_p02_zip;

/**
* @author EMMANUEL
*/
public class NodoBinario<T> {
	private T Dato;
	private NodoBinario<T> Izquierda;
	private NodoBinario<T> Derecha;
public NodoBinario(T dato){
	this.Dato=dato;
	this.Izquierda=null;
	this.Derecha=null;
}
public T getDato() {
	return Dato;
}
public void setDato(T dato) {
	Dato = dato;
}
public NodoBinario<T> getIzquierda() {
	return Izquierda;
}
public void setIzquierda(NodoBinario<T> izquierda) {
	this.Izquierda = izquierda;
}
public NodoBinario<T> getDerecha() {
	return Derecha;
}
public void setDerecha(NodoBinario<T> derecha) {
	this.Derecha = derecha;
}
}
