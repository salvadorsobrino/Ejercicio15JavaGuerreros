package vista;

import entidades.Curandero;
import entidades.Espada;
import entidades.Guerrero;
import entidades.Hechizo;
import entidades.Mago;
import entidades.Rezo;

public class mainCombate {

	public static void main(String[] args) {
		Guerrero g1 = new Guerrero();
		Espada e1 = new Espada();
		e1.setNombre("Excalibur");
		e1.setDanoMaximo(10);
		e1.setDanoMinimo(5);
		g1.setNombre("Paco");
		g1.setArma(e1);
		g1.setVida(100);
		g1.setFuerza(10);
		
		Guerrero g2 = new Guerrero();
		Espada e2 = new Espada();
		e2.setNombre("Katana");
		e2.setDanoMaximo(8);
		e2.setDanoMinimo(5);
		g2.setNombre("Yun");
		g2.setArma(e2);
		g2.setVida(100);
		g2.setFuerza(12);
		
		Combate c = new Combate();
		c.combatir(g1, g2);
		
		System.out.println("*************************SIGUIENTE COMBATE*************************");
		
		Mago m1 = new Mago();
		Hechizo h1 = new Hechizo();
		h1.setNombre("Avada Kedavra");
		h1.setDanoMaximo(10);
		h1.setDanoMinimo(7);
		
		m1.setNombre("Alejandro");
		m1.setArma(h1);
		m1.setVida(100);
		m1.setInteligencia(3);
		
		Curandero c1 = new Curandero();
		Rezo r1 = new Rezo();
		
		r1.setNombre("Alabare");
		r1.setDanoMaximo(10);
		r1.setDanoMinimo(3);
		
		c1.setNombre("Juan");
		c1.setArma(r1);
		c1.setVida(100);
		c1.setSabiduria(7);
		
		c = new Combate();
		c.combatir(m1, c1);
		
		System.out.println("*************************ULTIMO COMBATE*************************");
		
		c = new Combate();
		g1.setVida(100); // Se reestablece la vida de los Personajes para que vuelvan a combatir
		c1.setVida(100);
		
		g1.setArma(r1);
		c1.setArma(e2);
		c.combatir(g1, c1);
	}

}
