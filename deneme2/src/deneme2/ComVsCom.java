package deneme2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ComVsCom extends JPanel implements ActionListener{
	final static int GENISLIK = 1024;
	final static int YUKSEKLIK = 768;
	final static int KART_X = 96;
	final static int KART_Y = 160;
	int HIZALAMA = 20;
	int KARTBOSLUK = 20;
	int ISIMHIZA_X = 5;
	int ISIMHIZA_Y = 35;
	Font cardFont, skorFont, kalanFont, oyunSonu;
	Timer oyunDongusu = new Timer(2000,this);
	BilgisayarOyuncusu bilgisayarOyuncusu1 = new BilgisayarOyuncusu(1,0,"Computer1");
	BilgisayarOyuncusu bilgisayarOyuncusu2 = new BilgisayarOyuncusu(2,0,"Computer2");
	Pokemon oynananP1, oynananP2;
	ArrayList<Pokemon> kartListesi;
	int savasSayisi;
	
	public ComVsCom() {
		oyunDongusu.start();
		cardFont = new Font("Arial",Font.BOLD,14);
		skorFont = new Font("Arial", Font.PLAIN, 24);
		kalanFont = new Font("Arial", Font.PLAIN, 18);
		savasSayisi = 0;

		kartListesi = new ArrayList<>();
		kartListesi.add(new Bulbasaur(0,"Bulbasaur","Cim"));
		kartListesi.add(new Butterfree(1,"Butterfree","Hava"));
		kartListesi.add(new Charmander(2,"Charmander","Ates"));
		kartListesi.add(new Jigglypuff(3,"Jigglypuff","Ses"));
		kartListesi.add(new Meowth(4,"Meowth","Normal"));
		kartListesi.add(new Pikachu(5,"Pikachu","Elektrik"));
		kartListesi.add(new Psyduck(6,"Psyduck","Su"));
		kartListesi.add(new Snorlax(7,"Snorlax","Normal"));
		kartListesi.add(new Squirtle(8,"Squirtle","Su"));
		kartListesi.add(new Zubat(9,"Zubat","Hava"));

		kartDagit();
	}

	public void kartDagit(){
		int randomNum;
		Random rand = new Random();
		for(int i=0; i<3; i++){
			randomNum = rand.nextInt(kartListesi.size());
			bilgisayarOyuncusu1.getKartListesi().add(kartListesi.get(randomNum));
			kartListesi.remove(randomNum);
			randomNum = rand.nextInt(kartListesi.size());
			bilgisayarOyuncusu2.getKartListesi().add(kartListesi.get(randomNum));
			kartListesi.remove(randomNum);
		}
	}

	int randomNum, max=3, min=0;
	public void kartCek(){
		if(kartListesi.size() >= 2){
			Random rand = new Random();
			randomNum = rand.nextInt((max - min) + 1) + min;
			bilgisayarOyuncusu1.getKartListesi().add(kartListesi.get(randomNum));
			kartListesi.remove(randomNum);
			max = max-1;
			randomNum = rand.nextInt((max - min) + 1) + min;
			bilgisayarOyuncusu2.getKartListesi().add(kartListesi.get(randomNum));
			kartListesi.remove(randomNum);
			max = max-1;
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(cardFont);
		g.setColor(Color.gray);
		g.fillRect(GENISLIK/2 - KART_X/2 -384 -KARTBOSLUK/2 , YUKSEKLIK/2 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
		if(bilgisayarOyuncusu1.getKartListesi().size() == 3){
			g.setColor(Color.gray);
			g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
			g.fillRect(GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
			g.fillRect(GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(bilgisayarOyuncusu1.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(Integer.toString(bilgisayarOyuncusu1.getKartListesi().get(1).getHasarPuani()), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(Integer.toString(bilgisayarOyuncusu1.getKartListesi().get(2).getHasarPuani()), GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(bilgisayarOyuncusu1.getKartListesi().get(0).getPokemonAdi(),GENISLIK/2 - KART_X /2 +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
			g.drawString(bilgisayarOyuncusu1.getKartListesi().get(1).getPokemonAdi(),GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
			g.drawString(bilgisayarOyuncusu1.getKartListesi().get(2).getPokemonAdi(),GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
		}
		else if(bilgisayarOyuncusu1.getKartListesi().size() == 2){
			g.setColor(Color.gray);
			g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
			g.fillRect(GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(bilgisayarOyuncusu1.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(Integer.toString(bilgisayarOyuncusu1.getKartListesi().get(1).getHasarPuani()), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(bilgisayarOyuncusu1.getKartListesi().get(0).getPokemonAdi(),GENISLIK/2 - KART_X /2 +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
			g.drawString(bilgisayarOyuncusu1.getKartListesi().get(1).getPokemonAdi(),GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
		}
		else if(bilgisayarOyuncusu1.getKartListesi().size() == 1) {
			g.setColor(Color.gray);
			g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(bilgisayarOyuncusu1.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(bilgisayarOyuncusu1.getKartListesi().get(0).getPokemonAdi(), GENISLIK / 2 - KART_X / 2 +ISIMHIZA_X, YUKSEKLIK / 5 - KART_Y / 2 - HIZALAMA + ISIMHIZA_Y);
		}

		if(bilgisayarOyuncusu2.getKartListesi().size() == 3){
			g.setColor(Color.gray);
			g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
			g.fillRect(GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
			g.fillRect(GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(bilgisayarOyuncusu2.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(Integer.toString(bilgisayarOyuncusu2.getKartListesi().get(1).getHasarPuani()), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(Integer.toString(bilgisayarOyuncusu2.getKartListesi().get(2).getHasarPuani()), GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(bilgisayarOyuncusu2.getKartListesi().get(0).getPokemonAdi(), GENISLIK/2 - KART_X /2 +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
			g.drawString(bilgisayarOyuncusu2.getKartListesi().get(1).getPokemonAdi(), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
			g.drawString(bilgisayarOyuncusu2.getKartListesi().get(2).getPokemonAdi(), GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
		}
		else if(bilgisayarOyuncusu2.getKartListesi().size() == 2){
			g.setColor(Color.gray);
			g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
			g.fillRect(GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(bilgisayarOyuncusu2.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(Integer.toString(bilgisayarOyuncusu2.getKartListesi().get(1).getHasarPuani()), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(bilgisayarOyuncusu2.getKartListesi().get(0).getPokemonAdi(), GENISLIK/2 - KART_X /2 +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
			g.drawString(bilgisayarOyuncusu2.getKartListesi().get(1).getPokemonAdi(), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
		}
		else if(bilgisayarOyuncusu2.getKartListesi().size() == 1){
			g.setColor(Color.gray);
			g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(bilgisayarOyuncusu2.getKartListesi().get(0).getHasarPuani()), GENISLIK / 2 - KART_X / 2 +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK / 5 - KART_Y / 2 - HIZALAMA + ISIMHIZA_Y*3);
			g.drawString(bilgisayarOyuncusu2.getKartListesi().get(0).getPokemonAdi(), GENISLIK / 2 - KART_X / 2 +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK / 5 - KART_Y / 2 - HIZALAMA + ISIMHIZA_Y);
		}

		if(savasSayisi >= 1 && savasSayisi < 6){
			g.setColor(Color.gray);
			g.fillRect(GENISLIK / 2 - KART_X / 2 - KART_X / 2 - KARTBOSLUK / 2, YUKSEKLIK / 2 - KART_Y / 2 - HIZALAMA, KART_X, KART_Y);
			g.fillRect(GENISLIK / 2 - KART_X / 2 + KART_X / 2 + KARTBOSLUK / 2, YUKSEKLIK / 2 - KART_Y / 2 - HIZALAMA, KART_X, KART_Y);
			g.setColor(Color.darkGray);
			g.drawString(Integer.toString(oynananP1.getHasarPuani()), GENISLIK/2 - KART_X/2 - KART_X/2 -KARTBOSLUK/2 +ISIMHIZA_X*7, YUKSEKLIK/2 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(Integer.toString(oynananP2.getHasarPuani()), GENISLIK/2 - KART_X/2 + KART_X/2 +KARTBOSLUK/2 +ISIMHIZA_X*7, YUKSEKLIK/2 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
			g.drawString(oynananP1.getPokemonAdi(), GENISLIK/2 - KART_X/2 - KART_X/2 -KARTBOSLUK/2 +ISIMHIZA_X, YUKSEKLIK/2 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
			g.drawString(oynananP2.getPokemonAdi(), GENISLIK/2 - KART_X/2 + KART_X/2 +KARTBOSLUK/2 +ISIMHIZA_X, YUKSEKLIK/2 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
		}
		g.setColor(Color.darkGray);
		g.setFont(kalanFont);
		g.drawString("Destede", GENISLIK/2 - KART_X/2 -384 -KARTBOSLUK/2 +8, YUKSEKLIK/2 - KART_Y/2 +16);
		g.drawString("Kalan", GENISLIK/2 - KART_X/2 -384 -KARTBOSLUK/2 +8, YUKSEKLIK/2 - KART_Y/2 +48);
		g.drawString("Kartlar:", GENISLIK/2 - KART_X/2 -384 -KARTBOSLUK/2 +8, YUKSEKLIK/2 - KART_Y/2 +80);
		g.drawString(Integer.toString(kartListesi.size()),GENISLIK/2 - KART_X/2 -366 -KARTBOSLUK/2 +8,416);
		g.setFont(skorFont);
		g.setColor(Color.lightGray);
		bilgisayarOyuncusu1.skorGoster(g);
		bilgisayarOyuncusu2.skorGoster(g);
	}

	public void savas(Pokemon oynananP1, Pokemon oynananP2){
		if(oynananP1.getHasarPuani() > oynananP2.getHasarPuani()){
			bilgisayarOyuncusu1.setSkor(bilgisayarOyuncusu1.getSkor()+5);
		}else if(oynananP1.getHasarPuani() < oynananP2.getHasarPuani()){
			bilgisayarOyuncusu2.setSkor(bilgisayarOyuncusu2.getSkor()+5);
		}
	}

	public String kazananiBelirle(BilgisayarOyuncusu bilgisayarOyuncusu1, BilgisayarOyuncusu bilgisayarOyuncusu2){
		if(bilgisayarOyuncusu1.getSkor() > bilgisayarOyuncusu2.getSkor()){
			return "Computer1 Won!";
		}else if(bilgisayarOyuncusu1.getSkor() < bilgisayarOyuncusu2.getSkor()){
			return "Computer2 Won!";
		}else{
			return "Ended in Draw!";
		}
	}

	public void savasiBitir(String kazanan){
		Graphics g = getGraphics();
		g.setColor(Color.darkGray);
		g.fillRect(0,0,1024,768);
		oyunSonu = new Font("Arial",Font.PLAIN,64);
		g.setFont(oyunSonu);
		g.setColor(Color.lightGray);
		g.drawString(kazanan, 256, 384);
	}

	public int ortayiTemizle(){
		Graphics g = getGraphics();
		g.setColor(Color.darkGray);
		g.fillRect(GENISLIK / 2 - KART_X / 2 - KART_X / 2 - KARTBOSLUK / 2, YUKSEKLIK / 2 - KART_Y / 2 - HIZALAMA, 256, 256);
		return 1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(kartListesi.size() > 0 || bilgisayarOyuncusu1.getKartListesi().size() > 0 || bilgisayarOyuncusu2.getKartListesi().size() > 0) {
			oynananP1 = bilgisayarOyuncusu1.kartSec(0);
			oynananP2 = bilgisayarOyuncusu2.kartSec(0);
			savas(oynananP1, oynananP2);
			savasSayisi++;
			kartCek();
			repaint();
		}else{
			if(savasSayisi == 5) savasSayisi++;
			int temizlendi = ortayiTemizle();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			savasiBitir(kazananiBelirle(bilgisayarOyuncusu1, bilgisayarOyuncusu2));
			if(temizlendi ==1){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		}
	}
}
