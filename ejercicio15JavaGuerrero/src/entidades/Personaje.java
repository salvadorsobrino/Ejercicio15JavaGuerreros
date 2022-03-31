package entidades;

/*Todos podran tener un arma y un nombre, ademas tendran unos puntos
de vida y un atributo especifico, los magos tendran inteligencia, los
guerreros tendran fuerza y los Curanderos tendran Sabiduria*/
public abstract class Personaje {

	private String nombre;
	private Arma arma;
	private int vida;

	public Personaje() {

	}

	public abstract void atacar(Personaje p);

	public abstract void habilidadEspecial(Personaje p);

	public boolean critico() {
		boolean critico = false;
		int opcion = numero();
		if (opcion == 3) {
			System.out.println("�CRITICO!");
			critico = true;
		} else {
			critico = false;
		}
		return critico;
	}

	public boolean esquivar() {
		boolean esquivar = false;
		int opcion = numero();
		if (opcion == 2) {
			System.out.println("Esquiv� el ataque");
			esquivar = true;
		} else {
			esquivar = false;
		}
		return esquivar;
	}

	public int numero() {

		double random = Math.random();// Generamos un numero al azar entre 0 y 1

		if (random < 0.7) {// el 70% de las veces no hace nada el personaje
			return 1;
		}

		else if (random < 0.9) {// el 20% de las veces esquiva
			return 2;
		} else {// el 10% restante es la probabilidad de hacer cr�tico
			return 3;
		}
	}

	public boolean lanzarhabilidadEspecial() {
		boolean probabilidad = false;
		double random = Math.random();// Generamos un numero al azar entre 0 y 1

		if (random < 0.75) {// el 75% de las veces no hace nada el personaje
			probabilidad = false;
		} else if (random < 0.9) {// el 15% de las veces lanza la habilidad especial
			probabilidad = true;
		} else {// el 10% restante no hace nada
			probabilidad = false;
		}
		return probabilidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", arma=" + arma + ", vida=" + vida + "]";
	}

}
