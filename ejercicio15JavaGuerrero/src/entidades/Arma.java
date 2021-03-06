package entidades;

public abstract class Arma {

	private String nombre;
	private int danoMaximo;
	private int danoMinimo;

	public Arma() {
	}

	public int getDano() {
		// La formula para obtener un n?mero entre dos n?meros cual quiera es (X-Y+1)+Y.
		int numero = (int) (Math.random() * (danoMaximo - danoMinimo + 1) + danoMinimo);
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDanoMaximo() {
		return danoMaximo;
	}

	public void setDanoMaximo(int danoMaximo) {
		this.danoMaximo = danoMaximo;
	}

	public int getDanoMinimo() {
		return danoMinimo;
	}

	public void setDanoMinimo(int danoMinimo) {
		this.danoMinimo = danoMinimo;
	}

	@Override
	public String toString() {
		return "Arma [nombre=" + nombre + ", danoMaximo=" + danoMaximo + ", danoMinimo=" + danoMinimo + "]";
	}

}
