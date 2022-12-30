package icai.dtc.isw.ui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class LastPanel extends JPanel implements Serializable {

    public LastPanel(){
        this.setLayout(null);

        //insertar imagen
        JLabel imgFondoLast = new JLabel(" ");
        ImageIcon ImagenLast = new ImageIcon("src/main/resources/images/fondolastpanel.png");
        imgFondoLast.setIcon(ImagenLast);
        imgFondoLast.setSize(800, 900);
        imgFondoLast.setLocation(0, 0);
        imgFondoLast.setVisible(true);
        this.add(imgFondoLast);
    }

}
