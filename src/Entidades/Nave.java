
package Entidades;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.ImageIcon;

public class Nave {
    
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Image ednaldo;
    private LinkedList<Tiro> tiros;
    
    public Nave(){
        ImageIcon aux = new ImageIcon("img\\Nave.png");
        this.ednaldo = aux.getImage();
        this.x = 100;
        this.y = 120;
        this.tiros = new LinkedList<Tiro>();
    }
    
    public void atirar(){
        this.tiros.add(new Tiro(this.x, this.y));
    }

    public LinkedList<Tiro> getTiros() {
        return this.tiros;
    }
 
    
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Image getEdnaldo() {
        return this.ednaldo;
    }
    
    public void movimentacao(){
        this.x = this.x + this.dx;
        this.y = this.y + this.dy;
        
        if(this.x < 1){
            this.x = 1;
        }
        if(this.x > 462){
            this.x = 462;
        }
        
        if(this.y < 1){
            this.y = 1;
        }
        if(this.y > 340){
            this.y = 340;
        }
    }
    
    public void keyPressed(KeyEvent e){
        int aux = e.getKeyCode();
        
        if(aux == KeyEvent.VK_ENTER || aux == KeyEvent.VK_SPACE){
            this.atirar();
        }
        
        if(aux == KeyEvent.VK_W){
            this.dy = -1;
        }
        
        if(aux == KeyEvent.VK_S){
            this.dy = 1;
        }
        
        if(aux == KeyEvent.VK_A){
            this.dx = -1;
        }
        
        if(aux == KeyEvent.VK_D){
            this.dx = 1;
        }
    }
    
    public void keyReleased(KeyEvent e){
        int aux = e.getKeyCode();
        
        if(aux == KeyEvent.VK_W){
            this.dy = 0;
        }
        
        if(aux == KeyEvent.VK_S){
            this.dy = 0;
        }
        
        if(aux == KeyEvent.VK_A){
            this.dx = 0;
        }
        
        if(aux == KeyEvent.VK_D){
            this.dx = 0;
        }
    }
    
}
