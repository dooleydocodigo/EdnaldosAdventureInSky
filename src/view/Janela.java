
package view;
import javax.swing.JFrame;


public class Janela extends JFrame{
    
    public Janela(){
        
        this.add(new Fase());
        this.setTitle("Ednaldo's Adventure in Sky");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
