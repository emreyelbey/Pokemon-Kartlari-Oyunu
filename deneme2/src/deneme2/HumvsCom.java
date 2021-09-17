	package deneme2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class HumvsCom extends JPanel implements ActionListener,MouseListener{
    final static int GENISLIK = 1024;
    final static int YUKSEKLIK = 768;
    final static int KART_X = 96;
    final static int KART_Y = 160;
    int HIZALAMA = 20;
    int KARTBOSLUK = 20;
    int ISIMHIZA_X = 5;
    int ISIMHIZA_Y = 35;
    int tur = 1;
    int secilenKart = -1;
    Font cardFont, skorFont, kalanFont, oyunSonu;
    Timer oyunDongusu = new Timer(2000,this);
    BilgisayarOyuncusu bilgisayarOyuncusu = new BilgisayarOyuncusu(3,0,"Computer");
    InsanOyuncusu insanOyuncusu = new InsanOyuncusu(3,0,"Human");
    Pokemon oynananP1, oynananP2;
    ArrayList<Pokemon> kartListesi;
    int savasSayisi;
    int sunum = 1;

    public HumvsCom() {
        addMouseListener(this);
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
            bilgisayarOyuncusu.getKartListesi().add(kartListesi.get(randomNum));
            kartListesi.remove(randomNum);
            randomNum = rand.nextInt(kartListesi.size());
            insanOyuncusu.getKartListesi().add(kartListesi.get(randomNum));
            kartListesi.remove(randomNum);
        }
    }

    int randomNum, max=3, min=0;
    public void kartCek(){
        if(kartListesi.size() >= 2){
            Random rand = new Random();
            randomNum = rand.nextInt((max - min) + 1) + min;
            bilgisayarOyuncusu.getKartListesi().add(kartListesi.get(randomNum));
            kartListesi.remove(randomNum);
            max = max-1;
            randomNum = rand.nextInt((max - min) + 1) + min;
            insanOyuncusu.getKartListesi().add(kartListesi.get(randomNum));
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
        if(bilgisayarOyuncusu.getKartListesi().size() == 3){
            g.setColor(Color.gray);
            g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
            g.fillRect(GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
            g.fillRect(GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
            if(sunum == 1) {
            	g.setColor(Color.darkGray);
                g.drawString(Integer.toString(bilgisayarOyuncusu.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
                g.drawString(Integer.toString(bilgisayarOyuncusu.getKartListesi().get(1).getHasarPuani()), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
                g.drawString(Integer.toString(bilgisayarOyuncusu.getKartListesi().get(2).getHasarPuani()), GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
                g.drawString(bilgisayarOyuncusu.getKartListesi().get(0).getPokemonAdi(),GENISLIK/2 - KART_X /2 +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
                g.drawString(bilgisayarOyuncusu.getKartListesi().get(1).getPokemonAdi(),GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
                g.drawString(bilgisayarOyuncusu.getKartListesi().get(2).getPokemonAdi(),GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
            }
        }
        else if(bilgisayarOyuncusu.getKartListesi().size() == 2){
            g.setColor(Color.gray);
            g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
            g.fillRect(GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
            if(sunum == 1) {
            	g.setColor(Color.darkGray);
                g.drawString(Integer.toString(bilgisayarOyuncusu.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
                g.drawString(Integer.toString(bilgisayarOyuncusu.getKartListesi().get(1).getHasarPuani()), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
                g.drawString(bilgisayarOyuncusu.getKartListesi().get(0).getPokemonAdi(),GENISLIK/2 - KART_X /2 +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
                g.drawString(bilgisayarOyuncusu.getKartListesi().get(1).getPokemonAdi(),GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y);
            }
        }
        else if(bilgisayarOyuncusu.getKartListesi().size() == 1) {
            g.setColor(Color.gray);
            g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA, KART_X, KART_Y);
            if(sunum == 1) {
                g.setColor(Color.darkGray);
            	g.drawString(Integer.toString(bilgisayarOyuncusu.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK/5 - KART_Y/2 - HIZALAMA +ISIMHIZA_Y*3);
                g.drawString(bilgisayarOyuncusu.getKartListesi().get(0).getPokemonAdi(), GENISLIK / 2 - KART_X / 2 +ISIMHIZA_X, YUKSEKLIK / 5 - KART_Y / 2 - HIZALAMA + ISIMHIZA_Y);
            }
        }

        if(insanOyuncusu.getKartListesi().size() == 3){
            g.setColor(Color.gray);
            g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
            g.fillRect(GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
            g.fillRect(GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
            g.setColor(Color.darkGray);
            g.drawString(Integer.toString(insanOyuncusu.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
            g.drawString(Integer.toString(insanOyuncusu.getKartListesi().get(1).getHasarPuani()), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
            g.drawString(Integer.toString(insanOyuncusu.getKartListesi().get(2).getHasarPuani()), GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
            g.drawString(insanOyuncusu.getKartListesi().get(0).getPokemonAdi(), GENISLIK/2 - KART_X /2 +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
            g.drawString(insanOyuncusu.getKartListesi().get(1).getPokemonAdi(), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
            g.drawString(insanOyuncusu.getKartListesi().get(2).getPokemonAdi(), GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
        }
        else if(insanOyuncusu.getKartListesi().size() == 2){
            g.setColor(Color.gray);
            g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
            g.fillRect(GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
            g.setColor(Color.darkGray);
            g.drawString(Integer.toString(insanOyuncusu.getKartListesi().get(0).getHasarPuani()), GENISLIK/2 - KART_X /2 +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
            g.drawString(Integer.toString(insanOyuncusu.getKartListesi().get(1).getHasarPuani()), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y*3);
            g.drawString(insanOyuncusu.getKartListesi().get(0).getPokemonAdi(), GENISLIK/2 - KART_X /2 +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
            g.drawString(insanOyuncusu.getKartListesi().get(1).getPokemonAdi(), GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA +ISIMHIZA_Y);
        }
        else if(insanOyuncusu.getKartListesi().size() == 1){
            g.setColor(Color.gray);
            g.fillRect(GENISLIK/2 - KART_X /2, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y);
            g.setColor(Color.darkGray);
            g.drawString(Integer.toString(insanOyuncusu.getKartListesi().get(0).getHasarPuani()), GENISLIK / 2 - KART_X / 2 +ISIMHIZA_X*7, YUKSEKLIK - YUKSEKLIK / 5 - KART_Y / 2 - HIZALAMA + ISIMHIZA_Y*3);
            g.drawString(insanOyuncusu.getKartListesi().get(0).getPokemonAdi(), GENISLIK / 2 - KART_X / 2 +ISIMHIZA_X, YUKSEKLIK - YUKSEKLIK / 5 - KART_Y / 2 - HIZALAMA + ISIMHIZA_Y);
        }

        if(savasSayisi >= 1 && savasSayisi < 6 ){
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
        bilgisayarOyuncusu.skorGoster(g);
        insanOyuncusu.skorGoster(g);
    }

    public void savas(Pokemon oynananP1, Pokemon oynananP2){
        if(oynananP1.getHasarPuani() > oynananP2.getHasarPuani()){
            bilgisayarOyuncusu.setSkor(bilgisayarOyuncusu.getSkor()+5);
        }else if(oynananP1.getHasarPuani() < oynananP2.getHasarPuani()){
            insanOyuncusu.setSkor(insanOyuncusu.getSkor()+5);
        }
    }

    public String kazananiBelirle(BilgisayarOyuncusu bilgisayarOyuncusu1, InsanOyuncusu insanOyuncusu){
        if(bilgisayarOyuncusu1.getSkor() > insanOyuncusu.getSkor()){
            return "Computer Won!";
        }else if(bilgisayarOyuncusu1.getSkor() < insanOyuncusu.getSkor()){
            return "Player Won!";
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
        g.fillRect(GENISLIK / 2 - KART_X / 2 - KART_X / 2 - KARTBOSLUK / 2, YUKSEKLIK / 2 - KART_Y / 2 - HIZALAMA, 256, 200);
        return 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(tur % 2 != 0){
            oynananP2 = insanOyuncusu.kartSec(secilenKart);
            if(oynananP2 != null){
                tur++;
                repaint();
            }
            if(bilgisayarOyuncusu.getKartListesi().size() == 0){
                repaint();
                System.out.println(savasSayisi);
                if(savasSayisi == 5) {
                    savasSayisi++;
                    int temizlendi = ortayiTemizle();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    savasiBitir(kazananiBelirle(bilgisayarOyuncusu, insanOyuncusu));
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
        if(tur % 2 == 0){
            oynananP1 = bilgisayarOyuncusu.kartSec(0);
            savas(oynananP1,oynananP2);
            savasSayisi++;
            kartCek();
            secilenKart = -1;
            tur++;
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        int mouseX = e.getX();
        int mouseY = e.getY();

        if(mouseOver(mouseX, mouseY, GENISLIK/2 - KART_X /2 - KART_X - KARTBOSLUK, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y)){
            secilenKart = 1;
        }

        if(mouseOver(mouseX, mouseY, GENISLIK/2 - KART_X /2, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y)){
            secilenKart = 0;
        }

        if(mouseOver(mouseX, mouseY, GENISLIK/2 - KART_X /2 + KART_X + KARTBOSLUK, YUKSEKLIK - YUKSEKLIK/5 - KART_Y/2 -HIZALAMA, KART_X, KART_Y)){
            secilenKart = 2;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

	public boolean mouseOver(int mouseX,int mouseY,int x, int y, int w, int h) {
        if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
            return true;
        }
        return false;
    }
}
