package simulator;

public class Registar {
	
	private long vrijednost;
	private String naziv;
	private static int count=0;
	
	public Registar() {
		super();
		this.naziv = "reg" + (++count);
	}

	public Registar(long vrijednost, String naziv) {
		super();
		this.vrijednost = vrijednost;
		this.naziv = naziv;
	}

	public Registar(long vrijednost) {
		super();
		this.vrijednost = vrijednost;	
	}

	public void sub(long vrijednost) {
		this.vrijednost -= vrijednost;

	}
	
	public void add(long vrijednost) {
		this.vrijednost += vrijednost;
	}

	public long getVrijednost() {
		return vrijednost;
	}

	public void setVrijednost(long vrijednost) {
		this.vrijednost = vrijednost;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void and(long vrijednost) {
		this.vrijednost &= vrijednost;
	}

	public void or(long vrijednost) {
		this.vrijednost |= vrijednost;
	}

	public void not() {
		this.vrijednost = ~this.vrijednost;
	}

	public void mov(long vrijednost) {

		this.vrijednost = vrijednost;
	}

	public void unos(long vrijednost) {

		this.vrijednost = vrijednost;

	}

	public void ispis() {

		System.out.println(this.vrijednost);

	}
}
