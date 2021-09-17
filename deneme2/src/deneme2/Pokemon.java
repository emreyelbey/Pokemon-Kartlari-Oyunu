package deneme2;

public class Pokemon {
	
	private int pokemonID;
	private String pokemonAdi;
	private String pokemonTipi;
	
	Pokemon(){
		this.setPokemonID(-1);
		this.setPokemonAdi(null);
		this.setPokemonTipi(null);
	}
	
	Pokemon(int pokemonID, String pokemonAdi, String pokemonTipi){
		this.setPokemonID(pokemonID);
		this.setPokemonAdi(pokemonAdi);
		this.setPokemonTipi(pokemonTipi);
	}
	
	void HasarPuaniGoster(int hasarPuani){
		System.out.println(hasarPuani);
	}

	public String getPokemonTipi() {
		return pokemonTipi;
	}

	public void setPokemonTipi(String pokemonTipi) {
		this.pokemonTipi = pokemonTipi;
	}

	public int getPokemonID() {
		return pokemonID;
	}

	public void setPokemonID(int pokemonID) {
		this.pokemonID = pokemonID;
	}

	public String getPokemonAdi() {
		return pokemonAdi;
	}

	public void setPokemonAdi(String pokemonAdi) {
		this.pokemonAdi = pokemonAdi;
	}

	public int getHasarPuani(){
		return -1000;
	}
}
