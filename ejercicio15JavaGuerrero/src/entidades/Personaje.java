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

	/** M?todo abstracto que quien lo invoque atacar? a otro personaje
	 * @param p Indica el Personaje que va a atacar
	 */
	public abstract void atacar(Personaje p);

	/** M?todo abstracto que invoca la habilidad especial del personaje 
	 * @param p Indica el Personaje objetivo de su habilidad especial pudiendo ser el mismo.
	 */
	public abstract void habilidadEspecial(Personaje p);

	/** M?todo que se encarga de decidir si un golpe ser? critico 10%
	 * @return devuelve true en caso de ser critico en caso contrario false
	 */
	public boolean critico() {
		boolean critico = false;
		int opcion = numero();
		if (opcion == 3) {
			System.out.println("?CRITICO!");
			critico = true;
		} 
		return critico;
	}

	/** M?todo que se encarga de decidir si esquivar? el ataque 20%
	 * @return devuelve true en caso de esquivar en caso contrario false
	 */
	public boolean esquivar() {
		boolean esquivar = false;
		int opcion = numero();
		if (opcion == 2) {
			System.out.println("Esquiv? el ataque");
			esquivar = true;
		} else {
			esquivar = false;
		}
		return esquivar;
	}

	/** M?todo que se encarga de establecer las posibilidades de esquivar y de ser critico
	 * si devuelve 1 el 70% de las veces no hace nada el personaje
	 * si devuelve 2 el 20% de las veces esquiva
	 * si devuelve 3 el 10% restante es la probabilidad de hacer cr?tico
	 * @return Devuelve la opcion seleccionada.
	 */
	public int numero() {

		double random = Math.random();// Generamos un numero al azar entre 0 y 1

		if (random < 0.7) {// el 70% de las veces no hace nada el personaje
			return 1;
		}

		else if (random < 0.9) {// el 20% de las veces esquiva
			return 2;
		} else {// el 10% restante es la probabilidad de hacer cr?tico
			return 3;
		}
	}

	/** M?todo que se encarga de determinar si el personaje lanzara su habilidad especial
	 * gracias a un numero entre 075-0.9 siendo el 15% de las veces lanza la habilidad especial
	 * @return booleano que es true en caso de lance la habilidad el persona y false en caso contrario
	 */
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
