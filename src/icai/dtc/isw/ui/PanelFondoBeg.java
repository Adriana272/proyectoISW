package icai.dtc.isw.ui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PanelFondoBeg extends JPanel{
    public Image Imagenfondo;
    public PanelFondoBeg(){

        ImageIcon Imagenfondo = new ImageIcon("src/main/resources/images/fondopantallacomida.jpg");

    }

    public void paintComponent(Graphics g){
        g.drawImage(Imagenfondo, 0, 0, getWidth(), getHeight(), null);
    }
}
