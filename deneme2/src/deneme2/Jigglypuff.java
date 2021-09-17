package deneme2;

public class Jigglypuff extends Pokemon{
	
	private int hasarPuani = 70;
	private boolean kartKullanildiMi = false;

	Jigglypuff(){
		super(-1, null, null);
	}
	
	Jigglypuff(int pokemonID, String pokemonAdi, String pokemonTipi){
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
