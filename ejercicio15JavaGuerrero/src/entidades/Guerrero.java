package entidades;

/*Las espadas y arcos
seran armas que los guerreros usen mejor, los magos usaran de mejor 
manera los hechizos, mientras que los curanderos usaran mejor los
Rezos.*/
public class Guerrero extends Personaje {
	private int fuerza;

	public Guerrero() {
		super();
	}

	@Override
	public void atacar(Personaje p) {
		int dano = 0;
		if (this != p) { // No se puede atacar a si mismo
			System.out.println(this.getNombre() + " atac? a " + p.getNombre());
			if (!p.esquivar()) { // Si no esquiva le realizara el da?o (20% esquivar)
				if (this.getArma() instanceof Espada || this.getArma() instanceof Arco) {
					System.out.println("y esta utilizando su arma favorita");
					dano = this.getArma().getDano() + this.fuerza;
					System.out.println(this.getNombre() + " us? " + this.getArma().getNombre() + " e inflingi? " + dano
							+ " de da?o a " + p.getNombre());
					if (this.lanzarhabilidadEspecial()) { // Lanza su habilidad especial (15%)
						this.habilidadEspecial(p);
					}
				} else {
					System.out.println("y NO esta utilizando su arma favorita");
					dano = this.getArma().getDano();
					System.out.println(this.getNombre() + " us? " + this.getArma().getNombre() + " e inflingi? " + dano
							+ " de da?o a " + p.getNombre());
				}
				if (this.critico()) { // Golpe critico (10%)
					System.out.println("? " + dano + " X2 !");
					dano *= 2;
					System.out.println(this.getNombre() + " us? " + this.getArma().getNombre() + " e inflingi? " + dano
							+ " de da?o a " + p.getNombre());
				}
			}
		}
		p.setVida(p.getVida() - dano);
	}

	@Override
	public void habilidadEspecial(Personaje p) {
		if (this != p) {
			System.out.println(this.getNombre() + " lanz? su habilidad especial y ataca de nuevo con "
					+ this.getArma().getNombre());
			int dano = this.getArma().getDano() + this.fuerza;
			if (this.critico()) {
				System.out.println("? " + dano + " X2 !");
				dano *= 2;
			}
			System.out.println(this.getNombre() + " inflingi? " + dano + " de da?o a " + p.getNombre());
			p.setVida(p.getVida() - dano);
		}
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	@Override
	public String toString() {
		return "Guerrero " + this.getNombre() + " con Fuerza = " + fuerza + ", Vida = " + this.getVida() + ", Arma = "
				+ this.getArma();
	}

}
