package vista;

import entidades.Personaje;

public class Combate {
	private int turno = 0;

	public Combate() {

	}

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

	public boolean comprobarVida(Personaje p) {
		boolean vivo = true;
		if (p.getVida() <= 0) {
			vivo = false;
		}
		return vivo;
	}

	public void mostrarGanador(Personaje p1, Personaje p2) {
		if (p1.getVida() > 0) {
			System.out.println("Ganador " + p1.toString());
		} else {
			System.out.println("Ganador " + p2.toString());
		}
	}

	public void mostrarvida(Personaje p1, Personaje p2) {
		if (p1.getVida() < 0) {
			p1.setVida(0);
		}
		if (p2.getVida() < 0) {
			p2.setVida(0);
		}
		System.out.println("====================INFORMACI�N:====================");
		System.out.println("Vida de " + p1.getNombre() + ": " + p1.getVida());
		System.out.println("Vida de " + p2.getNombre() + ": " + p2.getVida());
		System.out.println("====================================================");

	}
}