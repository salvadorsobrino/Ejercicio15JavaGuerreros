package entidades;

public class Curandero extends Personaje {
	private int sabiduria;

	public Curandero() {
		super();
	}

	@Override
	public void atacar(Personaje p) {
		int dano = 0;
		if (this != p) {
			System.out.println(this.getNombre() + " atac? a " + p.getNombre());
			if (!p.esquivar()) {
				if (this.getArma() instanceof Rezo) {
					System.out.println("y esta utilizando su arma favorita");
					dano = this.getArma().getDano() + this.sabiduria;
					System.out.println(this.getNombre() + " us? " + this.getArma().getNombre() + " e inflingi? " + dano
							+ " de da?o a " + p.getNombre());
					if (this.lanzarhabilidadEspecial()) {
						this.habilidadEspecial(this);
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
		int curacion = this.sabiduria + this.getArma().getDano();
		System.out.println(this.getNombre() + " lanz? su habilidad especial y se cura " + curacion + " puntos de vida");
		p.setVida(p.getVida() + curacion);
	}

	public int getSabiduria() {
		return sabiduria;
	}

	public void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}

	@Override
	public String toString() {
		return "Curandero " + this.getNombre() + " con Sabiduria = " + sabiduria + ", Vida = " + this.getVida()
				+ ", Arma = " + this.getArma();
	}
}
