package vista;

import entidades.Personaje;

public class Combate {
	private int turno = 0;

	public Combate() {

	}

	/** M?todo que consta de un while para hacer que los dos Personajes se ataquen y pierdan vida
	 * @param p1 Personaje 1 que ataca a Personaje 2
	 * @param p2 Personaje 2 que ataca a Personaje 1
	 */
	public void combatir(Personaje p1, Personaje p2) {
		while (comprobarVida(p1) && comprobarVida(p2)) {
			this.turno += 1;
			System.out.println("======================TURNO " + this.turno + ":=====================");
			mostrarvida(p1, p2);
			p1.atacar(p2);
			mostrarvida(p1, p2);
			if (p2.getVida() > 0) {
				p2.atacar(p1);
			}
		}
		System.out.println("======================GANADOR:======================");
		mostrarGanador(p1, p2);
		System.out.println("====================================================");
	}

	/** M?todo que comprueba que la vida sea menos o igual a 0 para terminar el combate. Este metodo
	 * es para que quede m?s est?tico
	 * @param p El Personaje que queremos ver su vida 
	 * @return un booleano siendo true si tiene una vida mayor que 0 y false en caso contrario
	 */
	public boolean comprobarVida(Personaje p) {
		boolean vivo = true;
		if (p.getVida() <= 0) {
			vivo = false;
		}
		return vivo;
	}

	/** M?todo que sirve para mostrar al ganador del combate
	 * @param p1 Personaje 1 al cual se le comprueba su vida 
	 * @param p2 Personaje 2 si Personaje 1 no esta vivo es porque ha ganado Personaje 2
	 */
	public void mostrarGanador(Personaje p1, Personaje p2) {
		if (comprobarVida(p1)) {
			System.out.println("Ganador " + p1.toString());
		} else {
			System.out.println("Ganador " + p2.toString());
		}
	}

	/** M?todo est?tico que sirve para mostrar la vida de los personajes y en caso de que sea
	 * negativa establecerla a 0 y no aparezca -20 de vida al ser derrotado un Personaje.
	 * @param p1 Personaje 1 para obtener su nombre y vida 
	 * @param p2 Personaje 2 para obtener su nombre y vida 
	 */
	public void mostrarvida(Personaje p1, Personaje p2) {
		if (p1.getVida() < 0) {
			p1.setVida(0);
		}
		if (p2.getVida() < 0) {
			p2.setVida(0);
		}
		System.out.println("====================INFORMACI?N:====================");
		System.out.println("Vida de " + p1.getNombre() + ": " + p1.getVida());
		System.out.println("Vida de " + p2.getNombre() + ": " + p2.getVida());
		System.out.println("====================================================");

	}
}
