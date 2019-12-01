package dao;

public interface DaoJusticia {
	public int obtenerIdJuez();
	public void actualizarInstruccion(int idInstruccion,int idJuez,String estado);
	public int obtenerInstruccion();
	public int numInstruccionsPendientes();
}
