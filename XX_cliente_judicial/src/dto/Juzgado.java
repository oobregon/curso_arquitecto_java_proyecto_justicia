package dto;

public class Juzgado {
   private int idJuzgado;
   private int numeroJuzgado;
   private int idProvincia;
   private int idLocalidad;
   
      
public Juzgado() {
	super();
}
public Juzgado(int idJuzgado, int numeroJuzgado, int idProvincia, int idLocalidad) {
	super();
	this.idJuzgado = idJuzgado;
	this.numeroJuzgado = numeroJuzgado;
	this.idProvincia = idProvincia;
	this.idLocalidad = idLocalidad;
}
public int getIdJuzgado() {
	return idJuzgado;
}
public void setIdJuzgado(int idJuzgado) {
	this.idJuzgado = idJuzgado;
}
public int getNumeroJuzgado() {
	return numeroJuzgado;
}
public void setNumeroJuzgado(int numeroJuzgado) {
	this.numeroJuzgado = numeroJuzgado;
}
public int getIdProvincia() {
	return idProvincia;
}
public void setIdProvincia(int idProvincia) {
	this.idProvincia = idProvincia;
}
public int getIdLocalidad() {
	return idLocalidad;
}
public void setIdLocalidad(int idLocalidad) {
	this.idLocalidad = idLocalidad;
}
     

   
}
