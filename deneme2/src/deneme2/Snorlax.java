package deneme2;

public class Snorlax extends Pokemon{
	
	private int hasarPuani = 30;
	private boolean kartKullanildiMi = false;
	
	Snorlax(){
		super(-1, null, null);
	}
	
	Snorlax(int pokemonID, String pokemonAdi, String pokemonTipi){
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

