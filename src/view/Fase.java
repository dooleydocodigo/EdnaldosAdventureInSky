
package view;

import Entidades.Nave;
import Entidades.Tiro;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{
    
    private Image fundo;
    private Nave ednaldo;
    private Timer contador;
    
    public Fase(){
        
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());
        
        ImageIcon aux = new ImageIcon("img\\Fundo.png");
        this.fundo = aux.getImage();
        this.ednaldo = new Nave();
        
        this.contador = new Timer(5, this);
        contador.start();
    }
    
    public void paint(Graphics g){
        Graphics2D grafico = (Graphics2D) g;
        grafico.drawImage(this.fundo, 0, 0, null);
        grafico.drawImage(this.ednaldo.getEdnaldo(), this.ednaldo.getX(), this.ednaldo.getY(), this);
        LinkedList<Tiro> tiros = this.ednaldo.getTiros();
        
        for(int i = 0; i < tiros.size(); i++){
            Tiro t = (Tiro) tiros.get(i);
            grafico.drawImage(t.getTiro(), t.getX(), t.getY(), this);
        }
        
        g.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0){
        LinkedList<Tiro> tiros = this.ednaldo.getTiros();
        
        for(int i = 0; i < tiros.size(); i++){
            Tiro t = (Tiro) tiros.get(i);
            
            if(t.getFlag()){
                t.atirar();
            }
            else{
                tiros.remove(i);
            }
        }
        
        this.ednaldo.movimentacao();
        repaint();
    }
    
    private class TecladoAdapter extends KeyAdapter{
        
        @Override
        public void keyPressed(KeyEvent e){
            ednaldo.keyPressed(e);
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            ednaldo.keyReleased(e);
        }
    }
    
    
}
