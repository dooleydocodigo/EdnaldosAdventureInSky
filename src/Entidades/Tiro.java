package Entidades;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tiro {
    private static final int MAX = 500;
    private static final int VEL = 2;
    
    private int x;
    private int y;
    private Image tiro;
    private boolean flag;
    
    public Tiro(int x, int y){
        this.x = x;
        this.y = y;
        ImageIcon aux = new ImageIcon("img\\Tiro.png");
        this.tiro = aux.getImage();
        this.flag = true;
    }
    
    public void atirar(){
        this.x = this.x + VEL;
        if(this.x > MAX){
            this.flag = false;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Image getTiro() {
        return this.tiro;
    }
    
    public boolean getFlag(){
        return this.flag;
    }
    
    
    
    
    
}
