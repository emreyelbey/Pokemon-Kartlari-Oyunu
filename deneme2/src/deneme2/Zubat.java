package deneme2;

public class Zubat extends Pokemon{
	
	private int hasarPuani = 50;
	private boolean kartKullanildiMi = false;
	
	Zubat(){
		super(-1, null, null);
	}
	
	Zubat(int pokemonID, String pokemonAdi, String pokemonTipi){
		super(pokemonID, pokemonAdi, pokemonTipi);
	}

	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public boolean isKartKullanildiMi() {
		return kartKullanildiMi;
	}

	public void setKartKullanildiMi(boolean kartKullanildiMi) {
		this.kartKullanildiMi = kartKullanildiMi;
	}
}
