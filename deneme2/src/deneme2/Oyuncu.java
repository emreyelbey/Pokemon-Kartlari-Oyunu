package deneme2;

import java.awt.*;

public abstract class Oyuncu {
	
	private int oyuncuID;
	private int skor;
	private String oyuncuAdi;

	Oyuncu(){
		this.oyuncuID = -1;
		this.skor = -1;
		this.oyuncuAdi = null;
	}
	
	Oyuncu(int oyuncuID, int skor, String oyuncuAdi){
		this.oyuncuID = oyuncuID;
		this.skor = skor;
		this.oyuncuAdi = oyuncuAdi;
	}
	
	public abstract Pokemon kartSec(int kartIndis);
	
	void skorGoster(Graphics g){
	}

	public int getOyuncuID() {
		return oyuncuID;
	}

	public void setOyuncuID(int oyuncuID) {
		this.oyuncuID = oyuncuID;
	}

	public int getSkor() {
		return skor;
	}

	public void setSkor(int skor) {
		this.skor = skor;
	}

	public String getOyuncuAdi() {
		return oyuncuAdi;
	}

	public void setOyuncuAdi(String oyuncuAdi) {
		this.oyuncuAdi = oyuncuAdi;
	}
}
