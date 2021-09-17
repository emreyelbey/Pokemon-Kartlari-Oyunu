package deneme2;

import java.awt.*;
import java.util.ArrayList;

public class InsanOyuncusu extends Oyuncu{
	
	ArrayList<Pokemon> kartListesiHum = new ArrayList<Pokemon>();
	
	InsanOyuncusu(){
		super(-1, -1, null);
	}
	
	InsanOyuncusu(int oyuncuID, int skor, String oyuncuAdi){
		super(oyuncuID, skor, oyuncuAdi);
	}

	@Override
	public Pokemon kartSec(int kartIndis) {
		if(kartIndis != -1){
			Pokemon temp = kartListesiHum.get(kartIndis);
			kartListesiHum.remove(kartIndis);
			return temp;
		}
		return null;
	}

	@Override
	void skorGoster(Graphics g) {
			g.drawString("Player Score: " +Integer.toString(getSkor()),750, 673);
	}

	public ArrayList<Pokemon> getKartListesi() {
		return kartListesiHum;
	}

	public void setKartListesi(ArrayList<Pokemon> kartListesiHum) {
		this.kartListesiHum = kartListesiHum;
	}
}
