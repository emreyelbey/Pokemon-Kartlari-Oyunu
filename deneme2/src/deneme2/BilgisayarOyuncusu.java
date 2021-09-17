package deneme2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BilgisayarOyuncusu extends Oyuncu{
	
	private ArrayList<Pokemon> kartListesiBil = new ArrayList<Pokemon>();
	
	BilgisayarOyuncusu(){
		super(-1, -1, null);
	}
	
	BilgisayarOyuncusu(int oyuncuID, int skor, String oyuncuAdi){
		super(oyuncuID, skor, oyuncuAdi);
	}

	int randomNum;
	Random rand = new Random();
	@Override
	public Pokemon kartSec(int kartIndis) {
		randomNum = rand.nextInt(kartListesiBil.size());
		Pokemon temp = kartListesiBil.get(randomNum);
		kartListesiBil.remove(randomNum);
		return temp;
	}

	@Override
	public void skorGoster(Graphics g){
		if(getOyuncuID() == 1){
			g.drawString("Computer1 Score: " + Integer.toString(getSkor()),750, 75);
		}else if(getOyuncuID() == 2){
			g.drawString("Computer2 Score: " +Integer.toString(getSkor()),750, 673);
		}
		else{
			g.drawString("Computer Score: " +Integer.toString(getSkor()),750, 75);
		}
	}

	public ArrayList<Pokemon> getKartListesi() {
		return kartListesiBil;
	}

	public void setKartListesi(ArrayList<Pokemon> kartListesiBil) {
		this.kartListesiBil = kartListesiBil;
	}	
}
