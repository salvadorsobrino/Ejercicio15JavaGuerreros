package entidades;

public class Mago extends Personaje {

	private int inteligencia;

	public Mago() {
		super();
	}

	@Override
	public void atacar(Personaje p) {
		int dano = 0;
		if (this != p) {
			System.out.println(this.getNombre() + " atac? a " + p.getNombre());
			if (!p.esquivar()) {
				if (this.getArma() instanceof Hechizo) {
					System.out.println("y esta utilizando su arma favorita");
					dano = this.getArma().getDano() + this.inteligencia;
					System.out.println(this.getNombre() + " us? " + this.getArma().getNombre() + " e inflingi? " + dano
							+ " de da?o a " + p.getNombre());
					if (this.lanzarhabilidadEspecial()) {
						this.habilidadEspecial(p);
					}
				} else {
					System.out.println("y NO esta utilizando su arma favorita");
					dano = this.getArma().getDano();
					System.out.println(this.getNombre() + " us? " + this.getArma().getNombre() + " e inflingi? " + dano
							+ " de da?o a " + p.getNombre());
				}
				if (this.critico()) {
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
		System.out.println(this.getNombre() + " lanz? su habilidad especial y aument? su inteligencia");
		int inteligencia = this.getInteligencia();
		System.out.println(this.getNombre() + " ahora tiene " + inteligencia * 2 + " de inteligencia");
		this.setInteligencia(inteligencia * 2);
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	@Override
	public String toString() {
		return "Mago " + this.getNombre() + " con Inteligencia = " + inteligencia + ", Vida = " + this.getVida()
				+ ", Arma = " + this.getArma();
	}

}
