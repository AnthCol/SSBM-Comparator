package src.ui; 


import javax.swing.JFrame;
import javax.swing.JButton; 
import javax.swing.JPanel;



public class TierListUI{
    private ArrayList<String> charNames; 
    private ArrayList<BufferedImage> spritePaths; 

    public TierListUI(ArrayList<String> name, ArrayList<BufferedImage> sprite){
        charNames = name; 
        spritePaths = sprite; 
    }
}
